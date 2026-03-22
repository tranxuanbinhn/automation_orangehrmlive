package com.orangehrmlive.projects.cms.testcases;

import com.orangehrmlive.common.BaseTest;
import org.testng.annotations.BeforeClass;

public class AdduserTest extends BaseTest {
    private SignInTest signInTest;

    @BeforeClass
    private void prepareDate(){
        signInTest.signInWithAdminRole();
    }





}
