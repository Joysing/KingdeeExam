package com.kingdee.exam.mapper;

import com.kingdee.exam.KingdeeExamApplication;
import com.kingdee.exam.dao.UsersMapper;
import com.kingdee.exam.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserMapper测试类.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KingdeeExamApplication.class)
public class UserMapperTest {
	/**
	 * 测试用例: 测试getUserByUserId(long)方法
	 * 测试数据: 使用用户名为admin的用户的唯一标识符
	 * 预期结果: 返回预期的用户对象
	 */
	@Test
	public void testgetUserByUserIdExists() {
		User user = userMapper.getUserByUserId(1);
		Assertions.assertNotNull(user);
		
		System.out.println(user);
	}
	
	/**
	 * 测试用例: 测试getUserByUserId(long)方法
	 * 测试数据: 使用不存在的用户唯一标识符 
	 * 预期结果: 返回空引用
	 */
	@Test
	public void testgetUserByUserIdNotExists() {
		User user = userMapper.getUserByUserId(0);
        System.out.println(user);
	}
	
	/**
	 * 测试用例: 测试getUserUsingUsername(String)方法
	 * 测试数据: 使用用户名为admin的用户
	 * 预期结果: 返回预期的用户对象
	 */
	@Test
	public void testGetUserUsingUsernameExists() {
		User user = userMapper.getUserByUsername("admin");
		Assertions.assertNotNull(user);
		
		long uid = user.getUserId();
		System.out.println(uid);
		Assertions.assertEquals(1, uid);
	}
	
	/**
	 * 测试用例: 测试getUserUsingUsername(String)方法
	 * 测试数据: 使用不存在的用户名
	 * 预期结果: 返回空引用
	 */
	@Test
	public void testGetUserUsingUsernameNotExists() {
		User user = userMapper.getUserByUsername("Not-Exists");
		Assertions.assertNull(user);
	}
	
	/**
	 * 测试用例: 测试createUser(User)方法
	 * 测试数据: 使用合法的数据集, 但数据表中已存在相同的用户名
	 * 预期结果: 抛出org.springframework.dao.DuplicateKeyException异常
	 */
	@Test
	public void testCreateUserUsingExistingUsername() {
		User user = new User();
        user.setRoles("ROLE_USER");
        user.setUsername("admin");
        user.setPassword("$2a$10$TnsaY486k50PV.23Xi/82ePEQQkfziTFJIYW9SoYXWjFDLGlZKSP6");
        user.setPhone("18888888888");
        user.setTrueName("trueName");
        user.setEnabled(true);
		Executable e = () -> userMapper.insert(user);
		Assertions.assertThrows(org.springframework.dao.DuplicateKeyException.class, e);
	}
	

	/**
	 * 测试用例: 测试updateByPrimaryKey(User)方法
	 * 测试数据: 使用合法的数据集, 并且数据表中不存在相同用户名
	 * 预期结果: 数据更新操作成功完成
	 */
	@Test
	public void testupdateByPrimaryKeyNormally() {
		User user = userMapper.getUserByUserId(1);
		Assertions.assertNotNull(user);
		
		user.setUsername("admin1");
		int numberOfRowsAffected = userMapper.updateByPrimaryKey(user);
		Assertions.assertEquals(1, numberOfRowsAffected);
	}

	/**
	 * 测试用例: 测试deleteByPrimaryKey(long)方法
	 * 测试数据: 存在的用户唯一标识符
	 * 预期结果: 数据删除操作成功完成
	 */
	@Test
	public void testdeleteByPrimaryKeyExists() {
		User user = userMapper.getUserByUserId(7);
		Assertions.assertNotNull(user);
		
		int numberOfRowsAffected = userMapper.deleteByPrimaryKey("7");
		Assertions.assertEquals(1, numberOfRowsAffected);
		
		user = userMapper.getUserByUserId(7);
		Assertions.assertNull(user);
	}
	
	/**
	 * 测试用例: 测试deleteByPrimaryKey(long)方法
	 * 测试数据: 不存在的用户唯一标识符
	 * 预期结果: 方法正常执行, 未影响数据表中的数据
	 */
	@Test
	public void testdeleteByPrimaryKeyNotExists() {
		User user = userMapper.getUserByUserId(0);
		Assertions.assertNull(user);
		
		int numberOfRowsAffected = userMapper.deleteByPrimaryKey("0");
		Assertions.assertEquals(0, numberOfRowsAffected);
	}
	
	/**
	 * 待测试的UserMapper对象.
	 */
	@Autowired
	private UsersMapper userMapper;
}
