import pytest
from playwright.sync_api import Page, Browser

# Parametrize the browser_name, passing 'indirect=True' to use the browser fixture
@pytest.mark.parametrize("browser", ["chromium", "firefox", "webkit"], indirect=True)
def test_login(page: Page, browser: Browser):
    # Apply slow_mo when launching the browser (in the test script)
    context = browser.new_context()  # Create a new context without slow_mo here
    page = context.new_page()

    # Set a default timeout for actions on this page (e.g., fill, click)
    page.set_default_timeout(20000)  # Apply timeout for all page actions like fill(), click(), etc.

    # Apply timeout directly in navigation actions (like page.goto())
    page.goto('https://www.saucedemo.com/', timeout=10000, wait_until='load')  # Timeout for page navigation
    page.fill('#user-name', 'standard_user')  # This will now respect the default timeout
    page.fill('#password', 'secret_sauce')  # This will now respect the default timeout
    page.click('#login-button')  # This will now respect the default timeout

    # Verify successful login
    assert page.url == 'https://www.saucedemo.com/inventory.html'

    # No need to close context or page manually, as it's managed by the fixture
