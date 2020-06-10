#-*- coding: utf-8 -*-
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import unittest, time, re
import os,sys,csv
from ddt import ddt, data, unpack ,file_data


#读文件 文件里的参数
def getCsv(file_name):
    rows=[]
    path=sys.path[0]
    print (path)
    with open(path+'/json/'+file_name,'rt',encoding='utf8') as f:
        readers=csv.reader(f,delimiter=',',quotechar='|')
        next(readers,None)
        for row in readers:
            temprows=[]
            for i in row:
                temprows.append(i)
            rows.append(temprows)
        return rows
#引入ddt
@ddt
class baidu(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.baidu.com"
        self.verificationErrors = []
        self.accept_next_alert = True

    def tearDown(self):
        self.driver.quit()

    # 传多个数据
    @unittest.skip("skipping")
    @data("王凯", "欢乐颂", "蒋欣")
    def test_baidu(self,value):
        #def test_hao(self,value):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("kw").send_keys(value)
        driver.find_element_by_id("su").click()
        time.sleep(2)
    #传多组数据
    @unittest.skip("skipping")
    @data(["Lisa", "Lisa_百度搜索"], ["iu", "iu_百度搜索"],)
    @unpack
    def test_baidu2(self,value,expected_value):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("kw").send_keys(value)
        driver.find_element_by_id("su").click()
        time.sleep(2)

        self.assertEqual(expected_value,driver.title,msg="不一致")
        print(expected_value)
        print(driver.title)

    # 如何读取 txt文件
    @unittest.skip("skipping")
    #@data(*getCsv('mydata.txt'))
    #@unpack
    def test_baidu3(self, value, expected_value):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("kw").send_keys(value)
        driver.find_element_by_id("su").click()
        time.sleep(2)

        self.assertEqual(expected_value,driver.title,msg="不一致")
        print(expected_value)
        print(driver.title)

    #如何读取json文件
    @file_data('./json/data.json')
    def test_baidu4(self, value):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("kw").send_keys(value)
        driver.find_element_by_id("su").click()
        time.sleep(2)

if __name__ == "__main__":
#执行用例
    unittest.main()