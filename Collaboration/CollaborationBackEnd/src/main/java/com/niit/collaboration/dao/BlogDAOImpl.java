package com.niit.collaboration.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.model.Blog;

@Repository("blogDao")
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Blog> list() {
		@SuppressWarnings("unchecked")
		List<Blog> listBlog = sessionFactory.getCurrentSession().createCriteria(Blog.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listBlog;
	}

	@Transactional
	public Blog getBlog(String blogId) {
		String hql="from Blog where blog_id='"+blogId+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Blog> listBlog=(List<Blog>)query.list();
		
		if (listBlog != null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}

		return null;
	}

	@Transactional
	public void saveorupdate(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}

	@Transactional
	public void delete(String blogId) {
		Blog blogToDelete = new Blog();
		blogToDelete.setBlogId(blogId);
		sessionFactory.getCurrentSession().delete(blogToDelete);
	}

}
