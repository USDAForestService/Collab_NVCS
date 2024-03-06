'''
Created on May 2, 2013

@author: knimerfro
'''
import os
import re

# Example of "id" entry in a JSON file:
#   "id":
#      "Appalachian, Interior - Northeastern Mesic Forest LC (M883)",

def find_config_id(config):
    match = re.search(r"\"id\"\s*:\s*\"(.+)\"", config)
    return match if match is None else match.groups()[0]

def read_config_id(file):
    return find_config_id(open(file, 'r').read())

def read_config_ids(directory):
    #configs = {read_config_id(directory + f):directory + f for f in os.listdir(directory) if f.endswith('txt')}
    configs = {read_config_id(directory + f):"./key-nodes/" + f for f in os.listdir(directory) if f.endswith('txt')}
    return configs

def make_html(directory):
    prolog = ['<!DOCTYPE html>',
              '<html>',
              '<head>',
              '<style>',
              'div.sansserif{font-size:80%;font-family:Arial,Helvetica,sans-serif;}',
              'div.couriernew{font-size:70%;font-family:"Courier New";}',
              'a:link{color:inherit}',
              'a:active{color:inherit}',
              'a:visited{color:inherit}',
              'a:hover{color:inherit}',
              '</style>',
              '</head>',
              '<body>',
              '<div class="couriernew">',
              '<form>'
             ]    
    epilog = ['</form>',
              '</div>',
              '</body>',
              '</html>'
             ]    
    config_file = read_config_ids(directory + '/key-nodes/')
    bodydata = [['{0:>3}'.format(index+1).replace(' ', '&nbsp;'), '' if re.match(r'\t+', line) is None else re.match(r'\t+', line).group().replace('\t', '&nbsp;&nbsp;&nbsp;&nbsp;'), config_file[line.strip()], line.strip()] for index,line in enumerate(open(directory + '/key-hierarchy.txt', 'r'))]
    body = ['{0}<input type="checkbox" name="dummy" value="0">{1}<a href="{2}">{3}</a><br>'.format(index, level, ident, filename) for index, level, ident, filename in bodydata]
    return prolog + body + epilog

def write_html(directory, outfile):
    with open(outfile, 'w') as f:
        [f.write(line + '\n') for line in make_html(directory)]

if __name__ == '__main__':
    import html_maker
    html_maker.write_html('C:/nvcs-workspace/nvcs_west/nvcs_builder/generated-code/html', 'C:/nvcs-workspace/nvcs_west/nvcs_builder/generated-code/html/key.html')
    pass
