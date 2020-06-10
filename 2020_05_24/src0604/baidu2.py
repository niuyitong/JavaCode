# -*- coding: utf-8 -*-
import os

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import unittest, time, re


class Baidu1(unittest.TestCase):
    # test fixture，初始化环境
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.baidu.com/"
        self.verificationErrors = []
        self.accept_next_alert = True

    # 测试用例，必须以test开头

    def teardown(self):
        self.driver.quit()

    def test_hao(self):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_link_text("hao123").click()
        try:
            self.assertEqual("hao123_上网从这里开", driver.title)
        except:
            #错误截图
            self.savescreenshot(driver,"hao.png")
        #time.sleep(3)
        driver.get(self.base_url + "/")
        driver.find_element_by_id("kw").click()
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("kw").send_keys(u"测试")
        driver.find_element_by_id("su").click()
        driver.find_element_by_id("su").click()
        time.sleep(3)

    def savescreenshot(self,driver,file_name):
        if not os.path.exists('./image'):
            os.makedirs('./image')
        now=time.strftime("%Y%m%d-%H%M%S",time.localtime(time.time()))
#截图保存
        driver.get_screenshot_as_file('./image/'+now+'-'+file_name)
        time.sleep(1)


if __name__ == "__main__":
    # 执行用例
    unittest.main()
