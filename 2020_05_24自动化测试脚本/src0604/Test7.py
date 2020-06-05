import os
import time
from selenium import webdriver
from selenium.webdriver import ActionChains

driver = webdriver.Chrome()
file_path = 'file:///' + os.path.abspath("C:\\Users\\打野晓姐姐\\Desktop\\selenium2html\\modal.html")
driver.get(file_path)
time.sleep(3)
driver.find_element_by_link_text("Click").click()
time.sleep(3)
driver.find_element_by_id("click").click()
time.sleep(3)
driver.find_element_by_xpath("//*[@id=\"myModal\"]/div[3]/button[2]").click()
time.sleep(3)
driver.find_element_by_xpath("//*[@id=\"myModal\"]/div[3]/button[1]").click()
time.sleep(3)
driver.find_element_by_link_text("Click").click()
time.sleep(3)

time.sleep(3)
driver.quit()