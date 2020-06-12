SELECT * FROM user WHERE EXISTS (
    SELECT * FROM user_sub
      WHERE user.id = user_sub.id AND user_sub.job = "jobname"
  );
