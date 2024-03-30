Feature: Login with user credential

  Scenario Outline: Show message for invalid credential
    Given The login page showed for user
    When The user attempto login with their invalid credential with "<username>" and "<password>"
    Then The "<message>" should be showed
    Examples:
      |username|password|message|
      |lamgico@gmail.cm| abc1234|Có lỗi xảy ra:\n- Tài khoản không tồn tại, vui lòng kiểm tra lại|
      |khanh.tx@live.com|abc1234|Có lỗi xảy ra:\n- Mật khẩu không đúng, vui lòng kiểm tra lại|

  Scenario: Show dashboard for valid credential
    Given The login page showed for user
    When The user attempt to login with valid credentail with "khanh.tx@live.com" and "@2KhanhTran"
    Then The dashboard will be showed

