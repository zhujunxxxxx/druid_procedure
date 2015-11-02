/*
 * Copyright 1999-2101 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.bvt.filter.wall;

import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.druid.wall.WallUtils;

/**
 * 测试禁止多条语句执行的场景
 * @author admin
 *
 */
public class WallMultiStatementTest extends TestCase {
    private String sql = "SELECT email FROM members WHERE email = 'x'; UPDATE members SET email = 'steve@unixwiz.net' WHERE email = 'bob@example.com';";
    
    public void testOracle() throws Exception {
        Assert.assertFalse(WallUtils.isValidateOracle(sql));
    }
    
    public void testMySql() throws Exception {
        Assert.assertFalse(WallUtils.isValidateMySql(sql));
    }
}
