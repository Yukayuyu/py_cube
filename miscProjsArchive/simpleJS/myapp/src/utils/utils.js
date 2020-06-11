const mysql = require('mysql');
/**
 * Node.jsでMySQL 8.0へ接続する
 * エラー： ER_NOT_SUPPORTED_AUTH_MODE
 * 解決方法sql:
    ALTER USER 'hailang' IDENTIFIED WITH mysql_native_password BY '110119';
    FLUSH PRIVILEGES;
 */
const db = mysql.createConnection({
  host: 'localhost',
  database: 'flystone',
  user: 'root',
  password: 'root'
});

module.exports = {
  db
};
