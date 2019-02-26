package cn.com.lhd.web.listener;

import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.common.collect.Sets;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.core.page.SimplePage;
import cn.com.lhd.core.sort.Sorter;
import cn.com.lhd.web.entity.Film;
import cn.com.lhd.web.entity.FilmType;
import cn.com.lhd.web.service.IFilmService;
import cn.com.lhd.web.service.IFilmTypeService;

/**
 *
 * @desc 初始化容器监听器
 *
 */
public class ContainerListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext application = event.getServletContext();
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(application);
		
		// 电影类别归档
		IFilmTypeService iFilmTypeService = (IFilmTypeService) applicationContext.getBean("filmTypeServiceImpl");
		List<FilmType> filmTypeCountList = iFilmTypeService.queryWithFilmCount();
		application.setAttribute("filmTypeCountList", filmTypeCountList);
		
		// 热门电影
		IFilmService iFilmService = (IFilmService) applicationContext.getBean("filmServiceImpl");
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("click_count", false));
		IPage page = new SimplePage(1, 10);
		Film film = new Film();
		film.setStatus(1);
		List<Film> hotFilmList = iFilmService.queryList(film, null, sortSet, page);
		application.setAttribute("hotFilmList", hotFilmList);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}
	
}
