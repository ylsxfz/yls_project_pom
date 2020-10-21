package com.authority.manager.web.service.impl;

import com.authority.manager.web.dao.SysDeptJpaDAO;
import com.authority.manager.web.model.SysDeptDO;
import com.authority.manager.web.service.SysDeptJpaService;
import com.authority.manager.base.repository.BaseJpaDAO;
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
public class SysDeptJpaServiceImpl implements SysDeptJpaService {
    @Autowired
    private SysDeptJpaDAO sysDeptDao;
    @Override
    public BaseJpaDAO getDao() {
        return sysDeptDao;
    }

    @Override
    public List<SysDeptDO> findDeptTree() {
        //查询所有的数据
        List<SysDeptDO> deptList = sysDeptDao.findAll();
        //根据父级id查询
        Map<Integer,List<SysDeptDO>> detGroupByParentId = new HashMap<>();
        deptList.forEach(sysDept -> {
            int parentId = sysDept.getParentId();
            //判断根节点
            if(parentId==-1){
//                parentId = -1;
                //根节点的等级设为0
                sysDept.setLevel(0);
            }
            //如果不存在改父id的分组，新建一个
            if (detGroupByParentId.get(parentId)==null){
                List<SysDeptDO> sysDeptDOS = new ArrayList<>();
                sysDeptDOS.add(sysDept);
                detGroupByParentId.put(parentId, sysDeptDOS);
            //如果已经存在，往里面添加数据即可
            }else{
                detGroupByParentId.get(parentId).add(sysDept);
            }
        });

        //组装tree
        //获取根节点数据
        List<SysDeptDO> sysDeptsTreeDO = detGroupByParentId.get(-1);
        findChildren(sysDeptsTreeDO,detGroupByParentId);
        return sysDeptsTreeDO;
    }

    /**
     * @Author yls
     * @Description 组装部门tree
     * @Date 2020/4/6 13:29
     * @param sysDeptsTreeDO 部门对应的tree
     * @param detGroupByParentId  部门对应的根据父级id分组的map
     * @return void
     **/
    private void findChildren(List<SysDeptDO> sysDeptsTreeDO, Map<Integer,List<SysDeptDO>> detGroupByParentId){
        sysDeptsTreeDO.forEach(sysDept -> {
            List<SysDeptDO> childerns= detGroupByParentId.get(sysDept.getId());
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
