class Jugador:

    def __init__(self, nombre="Desconocido", posicion="Sin posición", numero_camiseta=0):
        self.__nombre          = nombre
        self.__posicion        = posicion
        self.__numero_camiseta = numero_camiseta

    @property
    def nombre(self):
        return self.__nombre

    @nombre.setter
    def nombre(self, valor):
        self.__nombre = valor

    @property
    def posicion(self):
        return self.__posicion

    @posicion.setter
    def posicion(self, valor):
        self.__posicion = valor

    @property
    def numero_camiseta(self):
        return self.__numero_camiseta

    @numero_camiseta.setter
    def numero_camiseta(self, valor):
        self.__numero_camiseta = valor

    def __str__(self):
        return f"{self.__nombre} | {self.__posicion} | #{self.__numero_camiseta}"