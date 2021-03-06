package com.centerm.fud_demo.service.Impl;

import com.centerm.fud_demo.dao.AdminDao;
import com.centerm.fud_demo.entity.User;
import com.centerm.fud_demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 管路员服务实现类
 * @author jerry
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;


    @Override
    public Boolean banUser(Long userId) {
        return adminDao.banUser(userId);
    }

    @Override
    public Boolean releaseUser(Long userId) {
        return adminDao.releaseUser(userId);
    }

    @Override
    public List<User> getUserExceptAdminAndSuperVIP(Long userId) {
        return adminDao.getUserExceptAdminAndSuperVIP(userId);
    }
}
