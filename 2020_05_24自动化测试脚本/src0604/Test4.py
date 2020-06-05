import os
import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys

driver = webdriver.Chrome()
file_path = 'file:///' + os.path.abspath("C:\\Users\\打野晓姐姐\\Desktop\\selenium2html\\frame.html")
driver.get(file_path)
time.sleep(3)
driver.switch_to.frame("f1")
driver.switch_to.frame("f2")
driver.find_element_by_id("kw").send_keys("张若昀")
driver.find_element_by_id("kw").send_keys(Keys.TAB)
driver.find_element_by_id("kw").send_keys(Keys.ENTER)
driver.find_element_by_id("kw").send_keys(Keys.CONTROL, 'a')
time.sleep(5)
driver.find_element_by_id("kw").send_keys(Keys.CONTROL, 'x')
driver.find_element_by_id("su").click()
time.sleep(3)
driver.quit()
