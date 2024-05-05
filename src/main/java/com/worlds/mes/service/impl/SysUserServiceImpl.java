package com.worlds.mes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.worlds.mes.dto.PermissionsMenuDto;
import com.worlds.mes.dto.ResultNoPageDto;
import com.worlds.mes.entity.*;
import com.worlds.mes.mapper.*;
import com.worlds.mes.service.SysUserService;
import com.worlds.mes.utils.HashUtil;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.RoleAnDeptAndMenuVo;
import com.worlds.mes.vo.SysUserVo;
import com.worlds.mes.vo.UserAndRoleAnDeptAndMenuVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.beans.Transient;
import java.util.*;

@Service
public class SysUserServiceImpl implements  SysUserService {

    private static Log log = LogFactory.getLog(SysUserServiceImpl.class);


    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;
    @Autowired
    private SysResourceMapper sysResourceMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<SysUser> listAll() {
        return sysUserMapper.listAll();
    }

    @Override
    public List<SysUser> testPlus(SysUser user) {
//        List<User> users = userMapper.selectList(null);
        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("login_name", user.getLoginName());
        userQueryWrapper.eq("pwd", user.getPwd());
        SysUser user1 = sysUserMapper.selectOne(userQueryWrapper);
        System.out.println(user1);
        List<SysUser> users = new ArrayList<>();
        users.add(user1);
        List<SysUser> userLambdaQueryChainWrapper = new LambdaQueryChainWrapper<>(sysUserMapper)
                .like(SysUser::getLoginName, user.getLoginName())
                .eq(SysUser::getLoginName, user.getLoginName()).list();
        System.out.println(userLambdaQueryChainWrapper);
        return users;
    }

    @Override
    public Page<HashMap<String, Object>> listAllByParam(SysUserVo sysUserVo) {
        SimplePageInfo pageInfo = sysUserVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getCount());
        Page<HashMap<String, Object>> page = (Page<HashMap<String, Object>>) sysUserMapper.listAllByParam(sysUserVo);
        return page;
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public SysUser getById(Integer id) {
        return sysUserMapper.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param sysUser 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    /**
     * 新增，忽略null字段
     *
     * @param sysUser 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(SysUser sysUser) {
        return sysUserMapper.insertIgnoreNull(sysUser);
    }

    /**
     * 修改，修改所有字段
     *
     * @param sysUser 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(SysUser sysUser) {
        return sysUserMapper.update(sysUser);
    }

    /**
     * 修改，忽略null字段
     *
     * @param sysUser 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(SysUser sysUser) {
        return sysUserMapper.updateIgnoreNull(sysUser);
    }

    /**
     * 删除记录
     *
     * @param sysUser 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(SysUser sysUser) {
        return sysUserMapper.deleteById(sysUser.getId());
    }


    /**
     * 根据用户名和用户id查询该用户的角色和菜单和部门
     *
     * @param roleAnDeptAndMenuVo
     * @return
     */
    @Override
    public List<PermissionsMenuDto> getRoleAnDeptAndMenu(RoleAnDeptAndMenuVo roleAnDeptAndMenuVo) {
        List<PermissionsMenuDto> res = new ArrayList<>();
        PermissionsMenuDto permissionsMenuDto = new PermissionsMenuDto();


        SysUser sysUser = new LambdaQueryChainWrapper<>(sysUserMapper)
                .eq(SysUser::getId, roleAnDeptAndMenuVo.getUserId())
                .eq(SysUser::getLoginName, roleAnDeptAndMenuVo.getLoginName()).one();

        if (null != sysUser) {
            // 查询部门
            List<SysDepartment> deptList = new ArrayList<>();
            SysDepartment dept = new LambdaQueryChainWrapper<>(sysDepartmentMapper)
                    .eq(SysDepartment::getId, sysUser.getDeptId()).one();
            if (null != dept) {
                deptList.add(dept);
                // 是不根节点 循环查子节点
                if (dept.getPid() != 0) {
                    while (true) {
                        // 查询pid
                        SysDepartment deptPid = new LambdaQueryChainWrapper<>(sysDepartmentMapper)
                                .eq(SysDepartment::getId, deptList.get(deptList.size() - 1).getPid()).one();
                        if (null == deptPid) {
                            break;
                        }
                        if (deptPid.getPid() == 0) {
                            break;
                        }
                        // 添加到集合
                        deptList.add(deptPid);
                    }
                }
                //根据id进行排序
                deptList.sort(Comparator.comparing(SysDepartment::getId));
                permissionsMenuDto.setDeptList(deptList);
            }

            // 查询角色-查询中间表
            List<SysRole> roleList = new ArrayList<>();
            List<SysUserRole> userRoleList = new LambdaQueryChainWrapper<>(sysUserRoleMapper)
                    .eq(SysUserRole::getUserId, sysUser.getId()).list();
            if (userRoleList.size() > 0) {
                userRoleList.forEach(role -> {
                    //查询角色
                    SysRole sysRole = new LambdaQueryChainWrapper<>(sysRoleMapper)
                            .eq(SysRole::getId, role.getRoleId()).one();
                    if (null != sysRole) {
                        roleList.add(sysRole);
                    }

                });
                // TODO: 2024/4/30  写查菜单 根据roleList
                if (roleList.size() > 1) {
                    List<SysResource> resourceList = new ArrayList<>();
                    //临时list
                    roleList.forEach(role -> {
                        if (resourceList.size() == 0) {
                            List<String> resourceids = Arrays.asList(role.getResourceId().split(","));
                            List<SysResource> sysResources = sysResourceMapper.selectBatchIds(resourceids);
                            sysResources.forEach(sysResource -> {
                                resourceList.add(sysResource);
                            });
                        } else {
                            List<String> resourceids = Arrays.asList(role.getResourceId().split(","));
                            for (String resourceid : resourceids) {
                                resourceList.forEach(resResource -> {
                                    if (!resourceid.equals(resResource.getId())) {
                                        SysResource sysResource = new LambdaQueryChainWrapper<>(sysResourceMapper)
                                                .eq(SysResource::getId, resourceid).one();
                                        resourceList.add(sysResource);
                                    }
                                });
                            }
                        }
                    });

                }
            }
        }
        // TODO: 2024/5/1 添加到redis中
        return res;
    }

    @Override
    @Transactional
    public ResultNoPageDto insertUserAndRoleAnDeptAndMenu(UserAndRoleAnDeptAndMenuVo userAndRoleAnDeptAndMenuVo) {
        ResultNoPageDto resultNoPageDto = new ResultNoPageDto();

        SysUser user = userAndRoleAnDeptAndMenuVo.getUser();
        user.setDeptId(Integer.valueOf(userAndRoleAnDeptAndMenuVo.getDeptId()));
        user.setRoleId(Integer.valueOf(userAndRoleAnDeptAndMenuVo.getRoleId()));
        user.setPwd(HashUtil.hash(user.getPwd()));
        int i = this.sysUserMapper.insertIgnoreNull(user);
        if (i <= 0) {
            resultNoPageDto.setCode(MesEnumUtils.CODE_5003);
            resultNoPageDto.setSuccess(false);
            resultNoPageDto.setMessage("用户数据新增失败请检查");
            return resultNoPageDto;
        }
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setRoleId(Integer.valueOf(userAndRoleAnDeptAndMenuVo.getRoleId()));
        sysUserRole.setUserId(user.getId());
        this.sysUserRoleMapper.insertIgnoreNull(sysUserRole);
        resultNoPageDto.setCode(MesEnumUtils.CODE_200);
        resultNoPageDto.setSuccess(true);
        resultNoPageDto.setMessage("成功");
        return resultNoPageDto;
    }


}