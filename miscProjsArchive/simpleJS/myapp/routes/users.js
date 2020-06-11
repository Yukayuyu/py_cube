const express = require('express');
const router = express.Router();
const userCtr = require('../src/controllers/user-controller');

/* GET users listing. */
router.get('/', userCtr.mainGet);
router.post('/request', userCtr.mainPost);

module.exports = router;
