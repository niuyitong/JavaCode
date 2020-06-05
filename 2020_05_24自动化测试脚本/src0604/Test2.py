import os
import time
from selenium import webdriver

driver = webdriver.Chrome()
file_path = 'file:///' + os.path.abspath("C:\\Users\\打野晓姐姐\\Desktop\\selenium2html\\checkbox.html")
driver.get(file_path)
time.sleep(5)
inputs = driver.find_elements_by_tag_name("input")
for input in inputs:
    if input.get_attribute("type") == "checkbox":
        input.click()
time.sleep(5)
driver.quit()
