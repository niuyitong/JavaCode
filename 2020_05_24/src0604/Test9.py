import os
import time
from selenium import webdriver
from selenium.webdriver import ActionChains

driver = webdriver.Chrome()
file_path = 'file:///' + os.path.abspath("C:\\Users\\打野晓姐姐\\Desktop\\selenium2html\\upload.html")
driver.get(file_path)
time.sleep(3)
driver.find_element_by_name("file").send_keys("C:\\Users\\打野晓姐姐\\Desktop\\selenium2html\\upload.html")
time.sleep(4)
driver.quit()