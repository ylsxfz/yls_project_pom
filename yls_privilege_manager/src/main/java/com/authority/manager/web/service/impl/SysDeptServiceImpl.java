package com.authority.manager.web.service.impl;

import com.authority.manager.web.dao.SysDeptDao;
import com.authority.manager.web.model.SysDept;
import com.authority.manager.web.service.SysDeptService;
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
public class SysDeptServiceImpl implements SysDeptService {
    @Autowired
    private SysDeptDao sysDeptDao;
    @Override
    public BaseDao getDao() {
        return sysDeptDao;
    }

    @Override
    public List<SysDept> findDeptTree() {
        //查询所有的数据
        List<SysDept> deptList = sysDeptDao.findAll();
        //根据父级id查询
        Map<String,List<SysDept>> detGroupByParentId = new HashMap<>();
        deptList.forEach(sysDept -> {
            String parentId = sysDept.getParentId();
            //判断根节点
            if(parentId==null || "".equals(parentId) || "0".equals(parentId)){
                parentId = "root";
                //根节点的等级设为0
                sysDept.setLevel(0);
            }
            //如果不存在改父id的分组，新建一个
            if (detGroupByParentId.get(parentId)==null){
                List<SysDept> sysDepts = new ArrayList<>();
                sysDepts.add(sysDept);
                detGroupByParentId.put(parentId,sysDepts);
            //如果已经存在，往里面添加数据即可
            }else{
                detGroupByParentId.get(parentId).add(sysDept);
            }
        });

        //组装tree
        //获取根节点数据
        List<SysDept> sysDeptsTree = detGroupByParentId.get("root");
        findChildren(sysDeptsTree,detGroupByParentId);
        return sysDeptsTree;
    }

    /**
     * @Author yls
     * @Description 组装部门tree
     * @Date 2020/4/6 13:29
     * @param sysDeptsTree 部门对应的tree
     * @param detGroupByParentId  部门对应的根据父级id分组的map
     * @return void
     **/
    private void findChildren(List<SysDept> sysDeptsTree, Map<String,List<SysDept>> detGroupByParentId){
        sysDeptsTree.forEach(sysDept -> {
            List<SysDept> childerns= detGroupByParentId.get(sysDept.getId());
            //判断是否有子部门
            if(childerns!=null){
                childerns.forEach(childern -> {
                    childern.setLevel(sysDept.getLevel()+1);
                });
                sysDept.setChildren(childerns);
                //递归扫描子级的children
                findChildren(childerns,detGroupByParentId);
            }
        });
    }
}
