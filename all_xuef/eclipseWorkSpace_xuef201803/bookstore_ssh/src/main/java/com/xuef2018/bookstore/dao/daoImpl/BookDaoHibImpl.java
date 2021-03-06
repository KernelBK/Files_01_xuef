package com.xuef2018.bookstore.dao.daoImpl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xuef2018.bookstore.dao.BaseDao;
import com.xuef2018.bookstore.dao.BookDao;
import com.xuef2018.bookstore.dbUtils.HibernateUtils;
import com.xuef2018.bookstore.domain.Book;
import com.xuef2018.bookstore.domain.web.ShoppingCartItem;
import com.xuef2018.bookstore.servlet.CriteriaBook;
import com.xuef2018.bookstore.servlet.Page;

public class BookDaoHibImpl extends BaseDao<Book> implements BookDao {
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public Book getBook(int id) {
		Book book = (Book) getSession().get(Book.class, id);
		return book;
	}
	@SuppressWarnings("unchecked")
	public List<Book> getAllBooks(){
		String hql = "FROM Book";
		return getSession().createQuery(hql).list();
	}


	public int getStoreNumber(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Page<Book> getPage(CriteriaBook cb) {
		Page<Book> page = new Page(cb.getPageNo());
		page.setTotalItemNumber((int)getTotalBookNumber(cb));
		cb.setPageNo(page.getPageNo());// 校正 cb(前端传入)的pageNo
		page.setList(getPageList(cb, page.getPageSize()));
		return page;
	}
	/**
	 * 根据cb 查询记录总数
	 */
	public long getTotalBookNumber(CriteriaBook cb) {
		String hql = "select count(*) from Book where price > ? and price < ?";
		Query query = getSession().createQuery(hql).
				setFloat(0, cb.getMinPrice()).
				setFloat(1, cb.getMaxPrice());
		Integer count = ((Long) query.iterate().next()).intValue();
		return count.longValue();
	}
	/**
	 * pageNo: 当前页
	 * minPrice, maxPrice
	 * pageSize: 每页显示条数 
	 */
	public List<Book> getPageList(CriteriaBook cb, int pageSize) {
		String sql = "from Book where price > ? and price < ?";
		int pageNo = cb.getPageNo();
		Query query = getSession().createQuery(sql);
		query.setFloat(0, cb.getMinPrice()).setFloat(1, cb.getMaxPrice());
		
		@SuppressWarnings("unchecked")
		List<Book> pageList = query.
				setFirstResult((pageNo-1) * pageSize).
				setMaxResults(pageSize).list();
		
		return pageList;
	}
	public void batchUpdateStoreNumberAndSalesAmount(
			Collection<ShoppingCartItem> items) {
		for(ShoppingCartItem sci : items){
			String hql = "update Book b set Salesamount = Salesamount + ?, "
					+ "Storenumber = Storenumber - ?"
					+ " where id = ?";
			Query query = getSession().createQuery(hql).setInteger(0, sci.getBookNum())
										 .setInteger(1, sci.getBookNum())
										 .setInteger(2, sci.getBook().getId());
			query.executeUpdate();
		}
	}

}
