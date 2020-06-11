const app = require('../../app');
const request = require('supertest');

describe('ユーザ取得テスト', () => {
  describe('異常系テスト', () => {
    it('画面区分が未設定', async () => {
      const response = await request(app).get('/users');
      expect(response.statusCode).toEqual(400);
      expect(response.body).toEqual({
        errorCode: 400,
        errorMessage: ['画面区分が未設定、値を入力してください！']
      });
    });
    it('ユーザIDが未設定', () => {
      request(app)
        .get('/users?screenCode=02&userId=')
        .then(response => {
          expect(response.statusCode).toEqual(400);
          expect(response.body).toEqual({
            errorCode: 400,
            errorMessage: ['ユーザIDが未設定、値を入力してください！']
          });
        });
    });
  });

  describe('正常系テスト', () => {
    it('ユーザ一覧取得', () => {
      request(app)
        .get('/users?screenCode=01')
        .then(response => {
          expect(response.statusCode).toBe(200);
        });
    });
    it('特定ユーザIDの取得', () => {
      request(app)
        .get('/users?screenCode=02&userId=1')
        .then(response => {
          expect(response.statusCode).toBe(200);
        });
    });
  });
});
