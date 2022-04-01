const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: { proxy: "http://localhost/", port: 8080 },
});
