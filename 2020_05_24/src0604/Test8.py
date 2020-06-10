import os
import time
from selenium import webdriver
from selenium.webdriver import ActionChains

driver = webdriver.Chrome()
file_path = 'file:///' + os.path.abspath("C:\\Users\\打野晓姐姐\\Desktop\\selenium2html\\send.html")
driver.get(file_path)
time.sleep(3)
driver.find_element_by_tag_name("input").click()
time.sleep(3)
alert = driver.switch_to.alert
alert.send_keys("你好呀")
time.sleep(2)
alert.accept()
time.sleep(3)
driver.quit()