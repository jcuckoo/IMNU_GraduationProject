package com.yq.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yq.entity.Address;
import com.yq.entity.Area;
import com.yq.entity.Cart;
import com.yq.entity.Coupons;
import com.yq.entity.Freight;
import com.yq.entity.Goods;
import com.yq.entity.GoodsJson;
import com.yq.entity.GoodsOther;
import com.yq.entity.Order;
import com.yq.entity.User;
import com.yq.service.AddressService;
import com.yq.service.AreaService;
import com.yq.service.CartService;
import com.yq.service.CouponsService;
import com.yq.service.FreightService;
import com.yq.service.GoodsService;
import com.yq.service.OrderService;
import com.yq.service.UserService;
import com.yq.util.PageUtil;
import com.yq.util.StringUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping
public class OrderCtrl extends StringUtil {
	@Autowired
	private OrderService orderService;
	private Order order = new Order();
	@Autowired
	private CartService cartService;
	private Cart cart = new Cart();
	@Autowired
	private CouponsService couponsService;
	private Coupons coupons = new Coupons();
	@Autowired
	private AddressService addressService;
	private Address address = new Address();
	@Autowired
	private FreightService freightService;
	private Freight freight = new Freight();
	@Autowired
	private UserService userService;
	private User user = new User();
	@Autowired
	private AreaService areaService;
	private Area area = new Area();
	@Autowired
	private GoodsService goodsService;
	private Goods goods = new Goods();
	Gson gson = new Gson();
	Map<String, Object> map = new HashMap<String, Object>();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Logger log = Logger.getLogger(this.getClass());
//	WechatPushMassage wechatPushMassage = new WechatPushMassage();

	@ResponseBody
	@RequestMapping(value = "/page/orderInsert.html")
	public String insert(String goods_id, String goods_name, String goods_img, String goods_spe, String goods_price,
			String goods_num, Float goods_total, Integer goods_total_num, Integer cps_id, String cps_name,
			@RequestParam(defaultValue = "0") Float cps_price, String addr_name, String receive, String oppen_id,
			Integer status, String note, HttpSession session) throws UnsupportedEncodingException {
		String add_time = sdf.format(new Date());
		oppen_id = getOppen_id(session);
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Order order = new Order();
		String order_id = sd.format(new Date());
		if(StringUtils.isNotEmpty(goods_name)){
			goods_name = java.net.URLDecoder.decode(goods_name,"utf-8") ;
		}
		if(StringUtils.isNotEmpty(goods_spe)){
			goods_spe = java.net.URLDecoder.decode(goods_spe,"utf-8") ;
		}
		if(StringUtils.isNotEmpty(cps_name)){
			cps_name = java.net.URLDecoder.decode(cps_name,"utf-8") ;
		}
		if(StringUtils.isNotEmpty(addr_name)){
			addr_name = java.net.URLDecoder.decode(addr_name,"utf-8") ;
		}
		if(StringUtils.isNotEmpty(receive)){
			receive = java.net.URLDecoder.decode(receive,"utf-8") ;
		}
		if(StringUtils.isNotEmpty(note)){
			note = java.net.URLDecoder.decode(note,"utf-8") ;
		}
		order.setOrder_id(order_id);
		order.setGoods_id(goods_id);
		order.setGoods_name(goods_name);
		order.setGoods_img(goods_img);
		order.setGoods_spe(goods_spe);
		order.setGoods_price(goods_price);
		order.setGoods_num(goods_num);
		order.setGoods_total(goods_total);
		order.setGoods_total_num(goods_total_num);
		order.setCps_id(cps_id);
		order.setCps_name(cps_name);
		order.setAddr_name(addr_name);
		order.setCps_price(cps_price);
		order.setReceive(receive);
		order.setOppen_id(oppen_id);
		order.setAdd_time(add_time);
		order.setStatus(0);
		order.setNote(note);
		if (orderService.insert(order) == 1) {
			if (goods_id.contains(",-=")) {
				String[] gids = goods_id.split(",-=");
				for (int i = 0; i < gids.length; i++) {
					map.put("goods_id", gids[i]);
					cartService.delete(map);
				}
			} else {
				map.put("goods_id", goods_id);
				session.setAttribute("cart_num", 0);
				cartService.delete(map);
			}
			if (cps_id != null) {
				map.put("status", 0);
				map.put("cps_id", cps_id);
				couponsService.upstatus(map);
			}
			return order_id;
		} else {
			return "0";
		}

	}

	@ResponseBody
	@RequestMapping(value = "/page/orderUpdate.html")
	public Object update(String order_id, @RequestParam(defaultValue = "1") Integer status, HttpSession session) {

		// setOppen_id("111", session);//测试代码，模仿登录
		// map.put("oppen_id", getOppen_id(session));
		map.put("order_id", order_id);
		map.put("status", status);
		return orderService.upstatus(map) + "";
	}

	@ResponseBody
	@RequestMapping(value = "/main/orderprice.html")
	public Object orderprice(String order_id,String goods_total, HttpSession session) {

		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String reorder_id = sf.format(new Date());
		map.put("status", 0);
//		map.put("order_id", order_id);
//		map.put("reorder_id", reorder_id);
//		orderService.upstatus(map);
		map.put("order_id", order_id);
		map.put("reorder_id", reorder_id);
		map.put("goods_total", goods_total);
		return orderService.upprice(map) + "";
	}
	@ResponseBody
	@RequestMapping(value = "/main/orderUpstatus.html")
	public Object upstatus(Integer status, String order_id,String express_dm,String express_hm,String express_name) throws UnsupportedEncodingException {
		if(StringUtils.isNotEmpty(express_name)){
			express_name = java.net.URLDecoder.decode(express_name,"utf-8") ;
		}
		map.put("order_id", order_id);
		map.put("status", status);
		map.put("express_dm", express_dm);
		map.put("express_hm", express_hm);
		map.put("express_name", express_name);
		int rs = orderService.upstatus(map);
//		if (rs == 1) {
//			order.setOrder_id(order_id);
//			List<Order> list = orderService.listById(order);
//			if (status == -6) {
//				map.put("result", "商家已同意退款");
//			} else {
//				map.put("result", "商家已发货");
//			}
//
//			map.put("body", list.get(0).getGoods_name().replace("-=", ""));
//			map.put("price", list.get(0).getGoods_total() + "");
//			map.put("oppen_id", list.get(0).getOppen_id());
////			wechatPushMassage.pushMessage(map);
//		}
		return rs + "";
	}

	@ResponseBody
	@RequestMapping(value = "/main/orderDel.html")
	public Object delete(String  order_id) {
		map.put("order_id", order_id);
		return orderService.delete(map) + "";
	}

	@RequestMapping(value = "/page/orderList.html")
	public ModelAndView list(@RequestParam(defaultValue = "-2") Integer status, String oppen_id, HttpSession session) {
		// setOppen_id("111", session);// 测试代码，模仿登录
		order.setOppen_id(getOppen_id(session));
		order.setStatus(-2);
		order.setStart_time("");
		order.setEnd_time("");
		order.setCtg_name("");
		order.setGoods_name("");
		order.setAddr_name("");
		List<Order> list = orderService.list(order); // 全部订单
		System.out.println("list=" + list.size());
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				List<Order> ordList = new ArrayList<Order>();
				String[] gId = list.get(i).getGoods_id().split(",-=");
				String[] gName = list.get(i).getGoods_name().split(",-=");
				String[] gImg = list.get(i).getGoods_img().split(",-=");
				String[] gPrice = list.get(i).getGoods_price().split(",-=");
				String[] gNum = list.get(i).getGoods_num().split(",-=");

				for (int m = 0; m < gId.length; m++) {
					Order ord = new Order();
					ord.setGoods_id(gId[m]);
					ord.setGoods_name(gName[m]);
					ord.setGoods_img(gImg[m]);
					ord.setGoods_price(gPrice[m]);
					ord.setGoods_num(gNum[m]);
					ordList.add(ord);
				}
				map.put("ord" + i, ordList);
			}
		}
		order.setStatus(0);
		List<Order> list0 = orderService.list(order);// 待付款订单
		if (list0.size() > 0) {
			for (int i = 0; i < list0.size(); i++) {
				List<Order> ordList = new ArrayList<Order>();
				String[] gId = list0.get(i).getGoods_id().split(",-=");
				String[] gName = list0.get(i).getGoods_name().split(",-=");
				String[] gImg = list0.get(i).getGoods_img().split(",-=");
				String[] gPrice = list0.get(i).getGoods_price().split(",-=");
				String[] gNum = list0.get(i).getGoods_num().split(",-=");
				for (int m = 0; m < gId.length; m++) {
					Order ord = new Order();
					ord.setGoods_id(gId[m]);
					ord.setGoods_name(gName[m]);
					ord.setGoods_img(gImg[m]);
					ord.setGoods_price(gPrice[m]);
					ord.setGoods_num(gNum[m]);
					ordList.add(ord);
				}
				map.put("ord0" + i, ordList);
			}
		}

		order.setStatus(1);
		List<Order> list1 = orderService.list(order);// 已付款待发货订单
		if (list1.size() > 0) {
			for (int i = 0; i < list1.size(); i++) {
				List<Order> ordList = new ArrayList<Order>();
				String[] gId = list1.get(i).getGoods_id().split(",-=");
				String[] gName = list1.get(i).getGoods_name().split(",-=");
				String[] gImg = list1.get(i).getGoods_img().split(",-=");
				String[] gPrice = list1.get(i).getGoods_price().split(",-=");
				String[] gNum = list1.get(i).getGoods_num().split(",-=");
				for (int m = 0; m < gId.length; m++) {
					Order ord = new Order();
					ord.setGoods_id(gId[m]);
					ord.setGoods_name(gName[m]);
					ord.setGoods_img(gImg[m]);
					ord.setGoods_price(gPrice[m]);
					ord.setGoods_num(gNum[m]);
					ordList.add(ord);
				}
				map.put("ord1" + i, ordList);
			}
		}
		order.setStatus(2);
		List<Order> list2 = orderService.list(order);// 已发货订单
		if (list2.size() > 0) {
			for (int i = 0; i < list2.size(); i++) {
				List<Order> ordList = new ArrayList<Order>();
				String[] gId = list2.get(i).getGoods_id().split(",-=");
				String[] gName = list2.get(i).getGoods_name().split(",-=");
				String[] gImg = list2.get(i).getGoods_img().split(",-=");
				String[] gPrice = list2.get(i).getGoods_price().split(",-=");
				String[] gNum = list2.get(i).getGoods_num().split(",-=");
				Order ord = new Order();
				for (int m = 0; m < gId.length; m++) {
					ord.setGoods_id(gId[m]);
					ord.setGoods_name(gName[m]);
					ord.setGoods_img(gImg[m]);
					ord.setGoods_price(gPrice[m]);
					ord.setGoods_num(gNum[m]);
					ordList.add(ord);
				}
				map.put("ord2" + i, ordList);
			}
		}
		map.put("list", list);
		map.put("list0", list0);
		map.put("list1", list1);
		map.put("list2", list2);
		ModelAndView ml = new ModelAndView();
		ml.addObject("map", map);
		ml.setViewName("page/order-list");
		return ml;
	}

	@ResponseBody
	@RequestMapping(value = "/main/order.html")
	public void orderListJs(@RequestParam(value="c" ,defaultValue = "1") Integer currentPage,
			@RequestParam( value="p" ,defaultValue = "0") Integer pageSize, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int total = orderService.listJsonCount(order);
		PageUtil.pager(currentPage, pageSize, total, request);
		order.setPageSize(pageSize);
		order.setCurrentNum(PageUtil.currentNum(currentPage, pageSize));
		List<Order> list = orderService.listJson(order);
		List<GoodsOther> goList = new ArrayList<GoodsOther>();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				List<GoodsJson> goodsList = new ArrayList<GoodsJson>();
				String[] gName = list.get(i).getGoods_name().split(",-=");
				String[] gNum = list.get(i).getGoods_num().split(",-=");
				String[] gPrice = list.get(i).getGoods_price().split(",-=");
				for (int m = 0; m < gName.length; m++) {
					GoodsJson gj = new GoodsJson();
					gj.setGoods_name(gName[m]);
					gj.setGoods_num(gNum[m]);
					gj.setGoods_price(gPrice[m]);
					goodsList.add(gj);
				}
				GoodsOther go = new GoodsOther();
				go.setAddr_name(list.get(i).getAddr_name());
				go.setNote(list.get(i).getNote());
				go.setAdd_time(list.get(i).getAdd_time());
				go.setGoodsList(goodsList);
				go.setTotal(total);
				goList.add(go);
			}
		}
		JSONArray json = JSONArray.fromObject(goList);
//		return gson.toJson(map);
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json.toString());
	}

	@RequestMapping(value = "/main/orderList.html")
	public ModelAndView orderList(@RequestParam(defaultValue = "1") Integer currentPage,
			@RequestParam(defaultValue = "-2") Integer status, @RequestParam(defaultValue = "") String start_time,
			@RequestParam(defaultValue = "") String end_time, @RequestParam(defaultValue = "") String ctg_name,
			@RequestParam(defaultValue = "") String goods_name, @RequestParam(defaultValue = "") String addr_name,
			HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
		start_time = java.net.URLDecoder.decode(start_time, "utf-8");
		end_time = java.net.URLDecoder.decode(end_time, "utf-8");
		ctg_name = java.net.URLDecoder.decode(ctg_name, "utf-8");
		goods_name = java.net.URLDecoder.decode(goods_name, "utf-8");
		addr_name = java.net.URLDecoder.decode(addr_name, "utf-8");
		order.setOppen_id("");
		order.setStatus(status);
		order.setStart_time(start_time);
		order.setEnd_time(end_time);
		order.setCtg_name(ctg_name);
		order.setGoods_name(goods_name);
		order.setAddr_name(addr_name);
		int total = orderService.count(order);
		PageUtil.pager(currentPage, pagesize_1, total, request);
		order.setPageSize(pagesize_1);
		order.setCurrentNum(PageUtil.currentNum(currentPage, pagesize_1));
		List<Order> list = orderService.list(order); // 全部订单
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				List<Order> ordList = new ArrayList<Order>();
				String[] gId = list.get(i).getGoods_id().split(",-=");
				String[] gName = list.get(i).getGoods_name().split(",-=");
				String[] gImg = list.get(i).getGoods_img().split(",-=");
				String[] gPrice = list.get(i).getGoods_price().split(",-=");
				String[] gNum = list.get(i).getGoods_num().split(",-=");

				for (int m = 0; m < gId.length; m++) {
					Order ord = new Order();
					ord.setGoods_id(gId[m]);
					ord.setGoods_name(gName[m]);
					ord.setGoods_img(gImg[m]);
					ord.setGoods_price(gPrice[m]);
					ord.setGoods_num(gNum[m]);
					ordList.add(ord);
				}
				map.put("ord" + i, ordList);
			}

		}
		map.put("list", list);
		ModelAndView ml = new ModelAndView();
		ml.addObject("map", map);
		ml.addObject("status", status);
		ml.addObject("start_time", start_time);
		ml.addObject("end_time", end_time);
		ml.addObject("ctg_name", ctg_name);
		ml.addObject("goods_name", goods_name);
		ml.addObject("addr_name", addr_name);
		ml.setViewName("main/order/list");
		return ml;
	}

	

	

	/**
	 * 从购物车获取订单
	 * 
	 * @param oppen_id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/page/cartOrderList.html")
	public ModelAndView cartList(@RequestParam(defaultValue = "0") Integer cps_id,
			@RequestParam(defaultValue = "0") Integer addr_id, String cps_name,
			@RequestParam(defaultValue = "0") Float cps_price, String oppen_id, HttpSession session) {
		ModelAndView ml = new ModelAndView();
		// setOppen_id("111", session);// 测试代码，模仿登录
		oppen_id = getOppen_id(session);
		cart.setOppen_id(oppen_id);
		List<Cart> list = cartService.list(cart); // 获取订单信息
		Float tprice = cartService.goodstotalprice(cart);// 总价
		ml.addObject("price", tprice); //
		int tnum = cartService.goodstotalnum(cart);// 总数量
		if (cps_id != null) {
			System.out.println(cps_id);
			if (cps_id != 0) {
				coupons.setCps_id(cps_id);
				List<Coupons> cps = couponsService.listById(coupons);// 优惠券
				if (cps.size() > 0) {
					cps_price = cps.get(0).getCps_price(); // 如果优惠券大于0，统计出此优惠券价格
				}
				ml.addObject("cps", cps);
			}
		}
		List<Address> addr = new ArrayList<Address>();
		if (addr_id == 0) {
			address.setOppen_id(oppen_id);
			addr = addressService.list(address);
		} else {
			address.setAddr_id(addr_id);
			addr = addressService.listById(address);
		}
		tprice = (tprice*100 - cps_price*100)/100; // 使用优惠券的总价
//		if(tprice<0){
//			tprice = 0F;
//		}
		List<Freight> fgt = freightService.list(freight);
		if (fgt.size() > 0) {
			if (tprice < fgt.get(0).getFree_price()) {
				tprice = tprice + fgt.get(0).getFgt_price(); // 如果总价小于免邮价，则加上运费
				ml.addObject("fgt_price", fgt.get(0).getFgt_price());
			} else {
				ml.addObject("fgt_price", 0);// 免运费
			}
		}
		String add_time = sf.format(new Date());

		coupons.setOppen_id(oppen_id);
		coupons.setCps_level(-1);
		coupons.setCps_time(add_time);
		coupons.setStatus(1);
		List<Coupons> cps = couponsService.list(coupons); // 获取用户优惠券
		// user.setOppen_id(oppen_id);
		// List<User> userList = userService.listById(user);

		area.setStatus(1);
		area.setLevel(0);
		List<Area> areaList = areaService.list(area);

		ml.addObject("goods", list);
		ml.addObject("tprice", tprice);
		System.err.println("tprice"+ tprice);
		ml.addObject("addr", addr);
		ml.addObject("tnum", tnum);
		ml.addObject("cpsCount", cps.size());
		ml.addObject("cps_id", cps_id);
		ml.addObject("addr_id", addr_id);
		// ml.addObject("userList", userList);
		ml.addObject("areaList", areaList);
		ml.setViewName("page/cart-order");
		return ml;
	}

	/**
	 * 商品直接下订单
	 * 
	 * @param oppen_id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/page/goodsOrderSure.html")
	public ModelAndView goodsOrder(Integer goods_id, Integer goods_num,
			@RequestParam(defaultValue = "0") Integer cps_id, @RequestParam(defaultValue = "0") Integer addr_id,
			String cps_name, @RequestParam(defaultValue = "0") Float cps_price, String oppen_id, HttpSession session) {
		ModelAndView ml = new ModelAndView();
		oppen_id = getOppen_id(session);
		cart.setOppen_id(oppen_id);
		goods.setGoods_id(goods_id);
		List<Goods> list = goodsService.listById(goods); // 获取订单信息
		Float goods_total = goods_num * list.get(0).getGoods_price();// 总价
		Float tprice = goods_num * list.get(0).getGoods_price();// 总价
		ml.addObject("price", tprice); //
		int tnum = cartService.goodstotalnum(cart);// 总数量

		// int tnum = goods_num;// 总数量
		if (cps_id != null) {
			System.out.println(cps_id);
			if (cps_id != 0) {
				coupons.setCps_id(cps_id);
				List<Coupons> cps = couponsService.listById(coupons);// 优惠券

				if (cps.size() > 0) {
					cps_price = cps.get(0).getCps_price(); // 如果优惠券大于0，统计出此优惠券价格
				}
				ml.addObject("cps", cps);
			}
		}
		List<Address> addr = new ArrayList<Address>();
		if (addr_id == 0) {
			address.setOppen_id(oppen_id);
			addr = addressService.list(address);
		} else {
			address.setAddr_id(addr_id);
			addr = addressService.listById(address);
		}
		tprice = (tprice*100 - cps_price*100)/100; // 使用优惠券的总价
		List<Freight> fgt = freightService.list(freight);
		if (fgt.size() > 0) {
			if (tprice < fgt.get(0).getFree_price()) {
				tprice = tprice + fgt.get(0).getFgt_price(); // 如果总价小于免邮价，则加上运费
				ml.addObject("fgt_price", fgt.get(0).getFgt_price());
			} else {
				ml.addObject("fgt_price", 0);// 免运费
			}
		}
		String add_time = sf.format(new Date());
		coupons.setOppen_id(oppen_id);
		coupons.setCps_level(-1);
		coupons.setCps_time(add_time);
		coupons.setStatus(1);
		List<Coupons> cps = couponsService.list(coupons); // 获取用户优惠券
		user.setOppen_id(oppen_id);
		List<User> userList = userService.listById(user);
		area.setStatus(1);
		area.setLevel(0);
		List<Area> areaList = areaService.list(area);
		ml.addObject("goods", list);
		ml.addObject("tprice", tprice);
		ml.addObject("addr", addr);
		ml.addObject("tnum", goods_num);
		ml.addObject("cps_id", cps_id);
		ml.addObject("addr_id", addr_id);
		ml.addObject("userList", userList);
		ml.addObject("goods_id", goods_id);
		ml.addObject("goods_num", goods_num);
		ml.addObject("goods_total", goods_total);

		ml.addObject("tnum", tnum);
		ml.addObject("cpsCount", cps.size());
		// ml.addObject("userList", userList);
		ml.addObject("areaList", areaList);
		ml.setViewName("page/goods-order-sure");
		return ml;
	}
	@RequestMapping(value = "/page/order.html")
	public ModelAndView goodsOrder(String order_id){
		ModelAndView ml = new ModelAndView();
		order.setOrder_id(order_id);
		ml.addObject("order", orderService.listById(order));
		ml.setViewName("page/express");
		return ml ;
	}

//	@RequestMapping(value = "orderPay.html")
//	public void orderPay() {
//
//	}

}
