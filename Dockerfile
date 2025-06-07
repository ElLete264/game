name: Publicar imagen Docker

on:
  push:
    branches:
      - master   # Se ejecuta al hacer push en la rama master

jobs:
  build-and-push:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout del repositorio
        uses: actions/checkout@v3

      - name: Login en Docker Hub
        uses: docker/login-action@v2
        with:
          username: ${{ secrets.DOCKERHUB_USERNAME }}   # mi usuario
          password: ${{ secrets.DOCKERHUB_TOKEN }}      # mi contraseña rara

      - name: Construir la imagen Docker
        run: docker build -t carlospereezzz/ahorcado-image:latest .

      - name: Subir imagen a Docker Hub
        run: docker push carlospereezzz/ahorcado-image:latest
