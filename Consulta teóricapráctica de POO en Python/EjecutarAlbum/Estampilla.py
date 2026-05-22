import sys, os
sys.path.insert(0, os.path.dirname(__file__))

from Jugador import Jugador


class Estampilla:

    def __init__(self, id_estampilla: str, jugador: Jugador, es_holografica: bool):
        self.__id_estampilla  = id_estampilla
        self.__jugador        = jugador
        self.__es_holografica = es_holografica

    @property
    def id_estampilla(self):
        return self.__id_estampilla

    @id_estampilla.setter
    def id_estampilla(self, valor):
        self.__id_estampilla = valor

    @property
    def jugador(self):
        return self.__jugador

    @jugador.setter
    def jugador(self, valor):
        self.__jugador = valor

    @property
    def es_holografica(self):
        return self.__es_holografica

    @es_holografica.setter
    def es_holografica(self, valor):
        self.__es_holografica = valor

    def __str__(self):
        holo = "Holográfica" if self.__es_holografica else "Normal"
        return f"Estampilla [{self.__id_estampilla}] — {self.__jugador} — {holo}"