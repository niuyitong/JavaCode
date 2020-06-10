import os
import time

from selenium import webdriver

#driver = webdriver.Chrome()
#driver.get("http://www.baidu.com")
#time.sleep(5)
#driver.implicitly_wait(10)
#driver.find_element_by_link_text("hao123").click()
#time.sleep(5)
from selenium.webdriver.common import alert

driver = webdriver.Chrome()
#在浏览器打开文件
file_path = 'file:///' + os.path.abspath("C:\\Users\\打野晓姐姐\\Desktop\\selenium2html\\alert.html")
driver.get(file_path)
driver.find_element_by_id("tooltip").click()
time.sleep(3)
alert = driver.switch_to.alert
alert.accept()
time.sleep(3)
driver.quit()


