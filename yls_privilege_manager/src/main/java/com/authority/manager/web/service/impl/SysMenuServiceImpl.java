package com.authority.manager.web.service.impl;

import com.authority.manager.web.dao.SysMenuDAO;
import com.authority.manager.web.model.SysMenuDO;
import com.authority.manager.web.service.SysMenuService;
import com.yls.core.repository.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yls
 * @Date 2020/4/5 12:04
 * @Description
 * @Version 1.0
 **/
@Transactional
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDAO sysMenuDao;
    @Override
    public BaseDao getDao() {
        return sysMenuDao;
    }

    @Override
    public List<SysMenuDO> findTree(String userName, int menuType) {
        List<SysMenuDO> sysMenuDOList = new ArrayList<>();

        if (menuType==1){
            sysMenuDOList = sysMenuDao.findByTypeNot(2);
        }

        if (menuType==0){
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
