import unittest
import pytest
from playwright.sync_api import Page

class MyTest(unittest.TestCase):
    @pytest.fixture(autouse=True)
    def setup(self, page: Page):
        self.page = page

    def test_foobar(self):
        self.page.goto("https://www.microsoft.com/en-us/")
        self.page.locator("[aria-label=\"Shop Surface Laptop\\, Copilot\\+ PC\"]").click()
        assert self.page.evaluate("1 + 1") == 2
