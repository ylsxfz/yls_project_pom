package com.authority.manager.web.service.impl;

import com.authority.manager.contant.SysContants;
import com.authority.manager.web.dao.SysMenuJpaDAO;
import com.authority.manager.web.dao.SysRoleMenuJpaDAO;
import com.authority.manager.web.dao.SysUserJpaDAO;
import com.authority.manager.web.dao.SysUserRoleJpaDAO;
import com.authority.manager.web.model.SysMenuDO;
import com.authority.manager.web.model.SysUserDO;
import com.authority.manager.web.model.relation.SysRoleMenuDO;
import com.authority.manager.web.model.relation.SysUserRoleDO;
import com.authority.manager.web.service.SysMenuJpaService;
import com.authority.manager.web.service.SysRoleJpaSerivce;
import com.yls.core.repository.BaseJpaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author yls
 * @Date 2020/4/5 12:04
 * @Description
 * @Version 1.0
 **/
@Transactional
@Service
public class SysMenuJpaServiceImpl implements SysMenuJpaService {
    @Autowired
    private SysMenuJpaDAO sysMenuDao;

    @Autowired
    private SysUserJpaDAO sysUserDao;

    @Autowired
    private SysRoleMenuJpaDAO sysRoleMenuDao;

    @Autowired
    private SysUserRoleJpaDAO sysUserRoleDao;

    @Autowired
    private SysRoleJpaSerivce sysRoleJpaSerivce;

    @Override
    public BaseJpaDAO getDao() {
        return sysMenuDao;
    }

    @Override
    public List<SysMenuDO> findTree(String userName, int menuType) {
        List<SysMenuDO> sysMenuDOList = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        /**
         * 只查询菜单列表，不查询按钮
         */
        if (menuType== SysContants.SEARCH_MENU){
            SysUserDO sysUserDO = sysUserDao.findByName(userName);
            int userDOId = sysUserDO.getId();
            Set<String> perms = new HashSet<>();
            List<SysMenuDO> sysMenuDOS = new ArrayList<>();
            // 超级管理员
            if (SysContants.ADMIN.equals(sysUserDO.getName())){
                sysMenuDOList  = sysMenuDao.findByTypeNot(SysContants.MENU_BUTTON);
            }else{
                /**
                 * 查询角色
                 */
                List<SysUserRoleDO> userRoleDOS = sysUserRoleDao.findByUserId(userDOId);
                userRoleDOS.forEach(sysUserRoleDO -> {
                    ids.add(sysUserRoleDO.getRoleId());
                });
                /**
                 * 查询菜单
                 */
                List<SysRoleMenuDO> sysRoleMenuDOS = sysRoleMenuDao.findByRoleIdIn(ids);
                List<Integer> menuids = new ArrayList<>();
                sysRoleMenuDOS.forEach(sysRoleMenu -> {
                    menuids.add(sysRoleMenu.getMenuId());
                });
                sysMenuDOList = sysMenuDao.findByTypeNotAndIdIn(SysContants.MENU_BUTTON,menuids);
            }
        }

        if (menuType==SysContants.SEARCH_MENU_AND_BUTTON){
            sysMenuDOList = sysMenuDao.findAll();
        }
        //根据父级id查询
        Map<Integer,List<SysMenuDO>> detGroupByParentId = new HashMap<>();
        sysMenuDOList.forEach(sysMenu -> {
            int parentId = sysMenu.getParentId();
            //判断根节点
            if(parentId==0){
                //根节点的等级设为0
                sysMenu.setLevel(0);
            }
            //如果不存在改父id的分组，新建一个
            if (detGroupByParentId.get(parentId)==null){
                List<SysMenuDO> sysMenuDOS = new ArrayList<>();
                sysMenuDOS.add(sysMenu);
                detGroupByParentId.put(parentId, sysMenuDOS);
                //如果已经存在，往里面添加数据即可
            }else{
                detGroupByParentId.get(parentId).add(sysMenu);
            }
        });

        //组装tree
        //获取根节点数据
        List<SysMenuDO> sysMenuDOTree = detGroupByParentId.get(0);
        findChildren(sysMenuDOTree,detGroupByParentId);

        return sysMenuDOTree;
    }

    /**
     * @Author yls
     * @Description 组装部门tree
     * @Date 2020/4/6 13:29
     * @param sysMenusTreeDO 菜单对应的tree
     * @param detGroupByParentId  菜单对应的根据父级id分组的map
     * @return void
     **/
    private void findChildren(List<SysMenuDO> sysMenusTreeDO, Map<Integer,List<SysMenuDO>> detGroupByParentId){
        if (sysMenusTreeDO == null || sysMenusTreeDO.isEmpty()){
            return;
        }
        sysMenusTreeDO.forEach(sysMenu -> {
            List<SysMenuDO> childerns= detGroupByParentId.get(sysMenu.getId());
            //判断是否有子部门
            if(childerns!=null){
                childerns.forEach(childern -> {
                    childern.setLevel(sysMenu.getLevel()+1);
                });
                sysMenu.setChildren(childerns);
                //递归扫描子级的children
                findChildren(childerns,detGroupByParentId);
            }
        });
    }
}
