package com.zale.aftersales.config;

import com.zale.aftersales.model.RolesPermissions;
import com.zale.aftersales.model.UserRoles;
import com.zale.aftersales.model.Users;
import com.zale.aftersales.service.RolesPermissionsService;
import com.zale.aftersales.service.UserRolesService;
import com.zale.aftersales.service.UsersService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class MyShiroRealm  extends AuthorizingRealm {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRolesService userRolesService;

    @Autowired
    private RolesPermissionsService rolesPermissionsService;

    @Override  //做授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从认证信息中获取到用户
        String userName = (String) principalCollection.getPrimaryPrincipal();
        //通过用户获取角色数据  从数据库或是缓存中获取数据
        //新建一个对象
        UserRoles userRoles = new UserRoles();
        //通过serivce获取到对象，并存储在userRoles里面
        userRoles = userRolesService.getUserRolesByUsername(userName);
        //把对象里面的身份部分放在role里面
        String role = userRoles.getRolename();
        HashSet<String> roles = new HashSet<String>();
        roles.add(role);
        //通过用户名获取权限数据
        HashSet<String> permissions = new HashSet<String>();
//        Set<String> permissions = rolesPermissionsService.get(userName);
        //新建一个对象
        RolesPermissions rolesPermissions = new RolesPermissions();
        rolesPermissions= rolesPermissionsService.getRolesPermissionsByUsername(userName);
        String permission = rolesPermissions.getPermission();
        permissions.add(permission);
        //授权、返回一个对象
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo ;
    }



    @Override  //做认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.从主体传过来的认证信息中，获得用户名
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        String userName = (String) authenticationToken.getPrincipal();

        //2.通过用户名到数据库中获取凭证
        Users user = new Users();
        user = usersService.getUsersByUsername(userName);
        String password = user.getPassword();
        if (password == null){
            return null;
        } //用户存在，要创建一个返回对象
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,password,"customRealm");
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userName));
        return authenticationInfo;
    }

//    //加盐一般是用随机数
//    public static void main(String[] args){
//        Md5Hash md5Hash = new Md5Hash("1234567","Mark");
//        System.out.println(md5Hash.toString());
//    }
}

