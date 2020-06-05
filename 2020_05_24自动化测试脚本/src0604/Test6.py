import os
import time
from selenium import webdriver
from selenium.webdriver import ActionChains

driver = webdriver.Chrome()
file_path = 'file:///' + os.path.abspath("C:\\Users\\打野晓姐姐\\Desktop\\selenium2html\\level_locate.html")
driver.get(file_path)
time.sleep(3)
driver.find_element_by_link_text("Link1").click()
time.sleep(3)
#driver.find_element_by_link_text("Action").click()
#time.sleep(3)
#拖动
action = driver.find_element_by_link_text("Action")
ActionChains(driver).move_to_element(action).perform()
time.sleep(3)

#list = driver.find_elements_by_id("dropdown1")

driver.quit()
