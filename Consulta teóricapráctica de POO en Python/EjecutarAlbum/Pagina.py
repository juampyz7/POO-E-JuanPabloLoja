import sys, os
sys.path.insert(0, os.path.dirname(__file__))

from Estampilla import Estampilla


class Pagina:

    def __init__(self, numero_pagina: int):
        self.__numero_pagina        = numero_pagina
        self.__estampilla_izquierda = None
        self.__estampilla_derecha   = None

    @property
    def numero_pagina(self):
        return self.__numero_pagina

    @numero_pagina.setter
    def numero_pagina(self, valor):
        self.__numero_pagina = valor

    @property
    def estampilla_izquierda(self):
        return self.__estampilla_izquierda

    @estampilla_izquierda.setter
    def estampilla_izquierda(self, estampilla: Estampilla):
        self.__estampilla_izquierda = estampilla

    @property
    def estampilla_derecha(self):
        return self.__estampilla_derecha

    @estampilla_derecha.setter
    def estampilla_derecha(self, estampilla: Estampilla):
        self.__estampilla_derecha = estampilla

    def __str__(self):
        izq = str(self.__estampilla_izquierda) if self.__estampilla_izquierda else "[ vacío ]"
        der = str(self.__estampilla_derecha)   if self.__estampilla_derecha   else "[ vacío ]"
        return f"Página {self.__numero_pagina} → Izq: {izq} | Der: {der}"