package film.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import film.bean.Root;
import film.mapper.RootLoginDao;




@Service
public class RootService {

	@Autowired
	private RootLoginDao rootloginDao;

	public List<Root> Login(Root rootInfo) {

		return rootloginDao.getRootLoginByBean(rootInfo);
	}
}
