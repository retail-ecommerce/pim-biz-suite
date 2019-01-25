const bizAppEnUS = {};
const bizAppZhCN = {};

bizAppZhCN.ThisObject = '本级目标权限';
bizAppEnUS.ThisObject = 'This Object';
bizAppZhCN.Test = '测试';
bizAppEnUS.Test = 'Test';
bizAppZhCN.Error = '错误';
bizAppEnUS.Error = 'Error';
bizAppZhCN.ErrorLog = '错误日志';
bizAppEnUS.ErrorLog = 'Error Log';
bizAppZhCN.ReadingPermission = '读取权限';
bizAppEnUS.ReadingPermission = 'Reading Permission';
bizAppZhCN.No = '否';
bizAppEnUS.No = 'No';
bizAppZhCN.UpdatePermission = '更新权限';
bizAppEnUS.UpdatePermission = 'Update Permission';
bizAppZhCN.ManagementPermission = '管理权限';
bizAppEnUS.ManagementPermission = 'Management Permission';
bizAppZhCN.StartedPermissionCode = '开始权限的代码';
bizAppEnUS.StartedPermissionCode = 'Started Permission Code';
bizAppZhCN.ListName = '列表名称';
bizAppEnUS.ListName = 'List Name';
bizAppZhCN.Platform = '平台';
bizAppEnUS.Platform = 'Platform';
bizAppZhCN.SelectTargetUser = '请选择要操作的用户';
bizAppEnUS.SelectTargetUser = 'Select Target User';
bizAppZhCN.SelectUser = '请选择用户';
bizAppEnUS.SelectUser = 'Select User';
bizAppZhCN.PermissionSetting = '权限设置';
bizAppEnUS.PermissionSetting = 'Permission Setting';
bizAppZhCN.DeletionPermission = '删除权限';
bizAppEnUS.DeletionPermission = 'Deletion Permission';
bizAppZhCN.Yes = '是';
bizAppEnUS.Yes = 'Yes';
bizAppZhCN.WritePermission = '写入权限';
bizAppEnUS.WritePermission = 'Write Permission';
bizAppZhCN.CreatePermission = '新增权限';
bizAppEnUS.CreatePermission = 'Create Permission';
bizAppZhCN.Email = '邮件';
bizAppEnUS.Email = 'Email';
bizAppZhCN.ExecutePermission = '执行权限';
bizAppEnUS.ExecutePermission = 'Execute Permission';

const oneOf = (value, candidates) => {
  return candidates.filter(item => item == value).length > 0;
};

const isLegalLocale = value => {
  return oneOf(value, ['enUS', 'zhCN']);
};

const determinLocale = userContext => {
  const defaultLocale = 'enUS';
  if (userContext == null) {
    const userLang = navigator.language || navigator.userLanguage;
    const trimedLocale = userLang.replace('-', '');
    if (isLegalLocale(trimedLocale)) {
      return trimedLocale;
    }
  }

  const userLocale = userContext.userLocale;
  if (isLegalLocale(userLocale)) {
    return userLocale;
  }

  return defaultLocale;
};

const internalLocaleName = (key, locale) => {
  if (locale == 'enUS') {
    return bizAppEnUS[key];
  }
  if (locale == 'zhCN') {
    return bizAppZhCN[key];
  }
  return null;
};

const localeName = (key, locale) => {
  const value = internalLocaleName(key, locale);
  if (value == null) {
    return key + 'NeedToFix';
  }
  return value;
};

const defaultLocaleName = (userContext, key) => {
  const locale = determinLocale(userContext);
  return localeName(key, locale);
};

export default defaultLocaleName;
