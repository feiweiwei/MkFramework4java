package com.monkey01.common.mybatisplus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import org.junit.Test;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * 测试生成代码
 * </p>
 *
 * @author
 * @date 2017/12/18
 */
public class GeneratorServiceEntity {

	@Test
	public void generateCode() {
		String packageName = "com.monkey01.springboot";
		boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
		generateByTables(serviceNameStartWithI, packageName, "test_user");
	}

	private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
		GlobalConfig config = new GlobalConfig();
		String dbUrl = "jdbc:mysql://123.206.118.12:3306/mkframework";
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.MYSQL)
				.setUrl(dbUrl)
				.setUsername("root")
				.setPassword("Fww198509!")
				.setDriverName("com.mysql.jdbc.Driver");
		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig
				.setCapitalMode(true)
				.setEntityLombokModel(false)
				.setDbColumnUnderline(true)
				.setNaming(NamingStrategy.underline_to_camel)
				.setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
		config.setActiveRecord(false)
				.setAuthor("monkey01")
//				.setOutputDir("d:\\codeGen")
				.setOutputDir("./codeGen")
				.setFileOverride(true);
		if (!serviceNameStartWithI) {
			config.setServiceName("%sService");
		}
		new AutoGenerator().setGlobalConfig(config)
				.setDataSource(dataSourceConfig)
				.setStrategy(strategyConfig)
				.setPackageInfo(
						new PackageConfig()
								.setParent(packageName)
								.setController("controller")
								.setEntity("entity")
				).execute();
	}

	private void generateByTables(String packageName, String... tableNames) {
		generateByTables(true, packageName, tableNames);
	}
}

