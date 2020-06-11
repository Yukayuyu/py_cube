const express = require('express');
const router = express.Router();
const path = require('path');

/* GET home page. */
router.get('/', function (req, res, next) {
  res.render('index', { title: 'Hello flystone!' });
});

// パスワード自動生成
const passCtr = require('../src/controllers/pass-controller');
router.get('/pass', function (req, res, next) {
  res.sendFile(path.join(__dirname, '../views/password.html'));
});
router.post('/pass', passCtr.main);

// DBからEXCEL作成し返却
const excelCtr = require('../src/controllers/excel-controller');
router.get('/dbExcel', excelCtr.getDbExcel);

// ファイルをアップロード
router.get('/upload', function (req, res, next) {
  res.sendFile(path.join(__dirname, '../views/upload.html'));
});

const multer = require('multer');
var storage = multer.diskStorage({
  //保存先を変更
  destination: function (req, file, cb) {
    var dir = path.join(__dirname, '../src/uploads/');
    cb(null, dir);
  },
  //ファイル名を変更
  filename: function (req, file, cb) {
    cb(null, file.originalname);
  },
});

const upload = multer({
  storage: storage,
});
router.post('/upload', upload.single('file'), excelCtr.postExcel);

// 課題：複数ファイルアップロードの場合は？

module.exports = router;
