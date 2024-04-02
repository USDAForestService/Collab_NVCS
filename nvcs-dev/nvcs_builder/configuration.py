import configparser


class DebugConfig:
    def __init__(self):
        self.configPath = "C:/Users/kelvynmeyers/Documents/GitHub/FS-Enterprise/NVCS/nvcs-dev/nvcs_builder/debug_config.ini"
        self.config = configparser.ConfigParser(interpolation=configparser.ExtendedInterpolation(), allow_no_value=True)
        self.config.read(self.configPath)
        self.base = "Config"
        self.westSection = "WestConfig"
        self.eastSection = "EastConfig"
        self.alaskaSection = "AlaskaSection"
        self.target = self.get(self.base, "TargetConfig")

    def get(self, section, prop):
        return_value = self.config.get(section, prop)
        if return_value == '':
            return_value = None
        return return_value