# Stage 1 : Compile and Build angular codebase

#use official node image as the base image
FROM node:lts-slim as build

#Set the working directory

WORKDIR /user/local/app

#Add the source of code to app

COPY ./ /user/local/app/

#Install all the dependencies
RUN npm install

#Generate the build of the application
RUN npm run build

#Stage 2: Serve app with nginx
FROM nginx:stable

COPY --from=build /user/local/app/dist/frontend/browser /usr/share/nginx/html

EXPOSE 80
