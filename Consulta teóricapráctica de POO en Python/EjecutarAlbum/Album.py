import sys, os
sys.path.insert(0, os.path.dirname(__file__))

from Pagina import Pagina
from Estampilla import Estampilla


class Album:

    def __init__(self, pagina1: Pagina, pagina2: Pagina):
        self.__pagina1 = pagina1
        self.__pagina2 = pagina2

    def calcular_porcentaje_completitud(self, total_estampillas_esperadas: int) -> float:
        if total_estampillas_esperadas == 0:
            return 0.0

        estampillas_actuales = 0

        for pagina in [self.__pagina1, self.__pagina2]:
            if pagina is not None:
                if pagina.estampilla_izquierda is not None:
                    estampillas_actuales += 1
                if pagina.estampilla_derecha is not None:
                    estampillas_actuales += 1

        return (estampillas_actuales / total_estampillas_esperadas) * 100.0

    def verificar_repetida(self, nueva_estampilla: Estampilla) -> bool:
        for pagina in [self.__pagina1, self.__pagina2]:
            if pagina is not None:
                if (pagina.estampilla_izquierda is not None and
                        pagina.estampilla_izquierda.id_estampilla == nueva_estampilla.id_estampilla):
                    return True
                if (pagina.estampilla_derecha is not None and
                        pagina.estampilla_derecha.id_estampilla == nueva_estampilla.id_estampilla):
                    return True
        return False

    @property
    def pagina1(self):
        return self.__pagina1

    @pagina1.setter
    def pagina1(self, valor):
        self.__pagina1 = valor

    @property
    def pagina2(self):
        return self.__pagina2

    @pagina2.setter
    def pagina2(self, valor):
        self.__pagina2 = valor