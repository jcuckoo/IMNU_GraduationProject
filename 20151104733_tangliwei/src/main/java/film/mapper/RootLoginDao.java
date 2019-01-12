package film.mapper;

import java.util.List;

import film.bean.Root;





public interface RootLoginDao {
	
	public List<Root> getRootLoginByBean(Root userInfo);
}
