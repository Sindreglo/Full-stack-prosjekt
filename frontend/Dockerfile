FROM node:latest

WORKDIR /

COPY package*.json ./

RUN npm install

EXPOSE 8081

CMD ["npm", "run", "serve"]