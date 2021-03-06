import flask 
from flask import request, jsonify
import pymysql.cursors

app = flask.Flask(__name__)
app.config["DEBUG"] = False

@app.route('/api/v1/resources/persons', methods=['GET'])
def api_all():
    conn = pymysql.connect(host='localhost', user='jose',password='Lkl15963',db='appmoviles',cursorclass=pymysql.cursors.DictCursor)

    try:
        with conn.cursor() as cursor:
            query = "select * from `tbpersonas` ;"
            cursor.execute(query)
            result= cursor.fetchall()
            return jsonify(result)
    finally:
        conn.close()

@app.route('/api/v1/resources/persons/select',methods=['GET'])
def api_filter():
    query_parameters = request.args

    rut=query_parameters.get('RUT')
    conn = pymysql.connect(host='localhost', user='jose',password='Lkl15963',db='appmoviles',cursorclass=pymysql.cursors.DictCursor)

    try:
        with conn.cursor() as cursor:
            query = "select * from `tbpersonas` where `RUT` = %s;"
            cursor.execute(query,rut)
            result= cursor.fetchone()
            return jsonify(result)
    finally:
        conn.close()

@app.route('/api/v1/resources/persons/insert',methods=['GET'])
def api_insert():
    query_parameters = request.args
    rut=query_parameters.get('RUT')
    nombre=query_parameters.get('NOMBRE')
    telefono=query_parameters.get('TELEFONO')
    mail=query_parameters.get('MAIL')

    conn = pymysql.connect(host='localhost', user='jose',password='Lkl15963',db='appmoviles',cursorclass=pymysql.cursors.DictCursor)

    try:
        with conn.cursor() as cursor: 
            query = "insert into `tbpersonas` (`RUT`, `NOMBRE`, `TELEFONO`, `MAIL`) values (%s,%s,%s,%s)"
            cursor.execute(query,(rut,nombre,telefono,mail))
        conn.commit()
        return jsonify(True)
    finally:
        conn.close()

@app.route('/api/v1/resources/persons/delete',methods=['GET'])
def api_delete():
    query_parameters = request.args
    rut=query_parameters.get('RUT')

    conn = pymysql.connect(host='localhost', user='jose',password='Lkl15963',db='appmoviles',cursorclass=pymysql.cursors.DictCursor)

    try:
        with conn.cursor() as cursor:
            query = "delete from `tbpersonas` where `RUT` = %s"
            cursor.execute(query,(rut))
        conn.commit()
        return jsonify(True)
    finally:
        conn.close()

@app.route('/api/v1/resources/persons/update',methods=['GET'])
def api_update():
    query_parameters = request.args
    rut=query_parameters.get('RUT')
    nombre=query_parameters.get('NOMBRE')
    telefono=query_parameters.get('TELEFONO')
    mail=query_parameters.get('MAIL')

    conn = pymysql.connect(host='localhost', user='jose',password='Lkl15963',db='appmoviles',cursorclass=pymysql.cursors.DictCursor)

    try:
        with conn.cursor() as cursor:
            query = "update `tbpersonas` set `NOMBRE`= %s, `TELEFONO`=%s, `MAIL`=%s  where `RUT` = %s"
            cursor.execute(query,(nombre,telefono,mail,rut))
        conn.commit()
        return jsonify(True)
    finally:
        conn.close()

app.run('192.168.1.81')