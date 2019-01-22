
const launcherEnUS = {}
const launcherZhCN = {}





const oneOf = (value, candidates) => {

    return candidates.filter(item => item == value).length > 0

}

const isLegalLocale = (value) => {

    return oneOf(value, ["enUS", "zhCN"])

}



const determinLocale = (userContext) => {
    const defaultLocale = 'enUS'
    if (userContext == null) {
        const userLang = navigator.language || navigator.userLanguage
        const trimedLocale = userLang.replace("-", "")
        if (isLegalLocale(trimedLocale)) {
            return trimedLocale;
        }

    }

    const userLocale = userContext.userLocale
    if (isLegalLocale(userLocale)) {
        return userLocale;
    }

    return defaultLocale

}

const internalLocaleName = (key, locale) => {

    if (locale == 'enUS') {
        return launcherEnUS[key]
    }
    if (locale == 'zhCN') {
        return launcherZhCN[key]
    }
    return null
}

const localeName = (key, locale) => {


    const value = internalLocaleName(key, locale)
    if (value == null) {
        return key + "NeedToFix"
    }
    return value
}

const defaultLocaleName = (userContext, key) => {

    const locale = determinLocale(userContext)
    return localeName(key, locale)

}

export default defaultLocaleName

/*


密码|Password
平台|Platform
登录|Login
警告|Warning
下一步|Next Step
原密码|Old Password
手机号|Mobile Phone
新密码|New Password
用户名|Username
验证码|Verification Code
修改密码|Change password
修改成功|Changed Success
密码出错|Password Error
忘记密码|Forget Password
执行成功|Success
更多特性|More Features
更新密码|Change Password
登录出错|Sign In Error
该手机号|This Phone Number
输入错误|Input Error
返回主页|Return To Home
请输入密码|Please Input Your Password
验证码错误|Verification Code Error
密码输入不同|Passwords do not match
请联系管理员|Please contract admin
请输入手机号|Input Phone Number
请输入新密码|Input New Password
请输入旧密码|Please Input Old Pass
请输入用户名|Please Input Username
请输入验证码|Please Input Verification Code
重新输入密码|Please Input Pass
再次输入新密码|Please Input Pass Again
请尝试重新登录|Please Sign In Again
请重新输入密码|Please Input New Pass
两次密码输入不同|Password does not match
关联的用户找不到|Could Not Find User
请再次输入新密码|Please Input New Pass
两次输入的密码不一致|Passwords do not match
修改密码成功，请使用您的新密码|Password Update Success
*/