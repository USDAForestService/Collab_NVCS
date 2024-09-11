import configparser
import ast
import os

class DebugConfig:
    def __init__(self):
        self.fileDirectoryPath = os.path.dirname(__file__)
        self.configPath = os.path.join(self.fileDirectoryPath, "debug_config.ini")
        self.config = configparser.ConfigParser(interpolation=configparser.ExtendedInterpolation(), allow_no_value=True)
        self.config.read(self.configPath)
        self.base = "Config"
        self.fullOutputSection = "FullOutputConfig"
        self.westSection = "WestConfig"
        self.eastSection = "EastConfig"
        self.alaskaSection = "AlaskaSection"
        self.target = self.get(self.base, "TargetConfig")

    def get(self, section, prop):
        return_value = self.config.get(section, prop)
        if return_value == '':
            return_value = None
        return return_value

    def get_literal(self, section, prop):
        return_value = self.config.get(section, prop)
        if return_value == '':
            return_value = None
        return_value = ast.literal_eval(return_value)
        return return_value
