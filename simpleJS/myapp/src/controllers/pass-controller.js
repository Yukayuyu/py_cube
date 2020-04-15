module.exports.main = function main(req, res) {
  let { length, nc, uc, lc, sb } = req.body;

  let password_numeric = '1234567890';
  let password_uppercase = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
  let password_lowercase = 'abcdefghijklmnopqrstuvwxyz';
  let password_symbol = '!"#$%&()=~|@[];:+-*<>?_>.,\'';

  if (!length) length = 20;
  res.json({ passwd: genPassword(length) });

  function genPassword(length) {
    let password = '';
    let password_base = '';
    //生成ルールの確認
    if (nc) password_base += password_numeric;
    if (uc) password_base += password_uppercase;
    if (lc) password_base += password_lowercase;
    if (sb) password_base += password_symbol;
    for (let i = 0; i < length; i++) {
      password += password_base.charAt(
        Math.floor(Math.random() * password_base.length)
      );
    }
    return password;

    // 课题；四種類のデータ型を含めるの場合は？
  }
};
