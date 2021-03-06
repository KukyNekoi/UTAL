import psycopg2
import random
import string
from sys import stdout
from time import sleep

params = {
    'database': 'icpcdb',
    'user': 'postgres',
    'password': '1234',
    'host': '10.211.55.4',
    'port': 5432
}

conn = psycopg2.connect(**params)
cur = conn.cursor()
teams_id = -1;
con1_id = -1;
con2_id = -1;
con3_id = -1;
# create team
conn.set_isolation_level(psycopg2.extensions.ISOLATION_LEVEL_READ_UNCOMMITTED)
pid = -1;
cur.execute("SET CONSTRAINTS ALL IMMEDIATE;")
cur.execute("INSERT INTO problems VALUES(DEFAULT, 'A', 'A.pdf', 1, 'Elmano parece candy pero no es candy asi que candy candy aprende algo candy','notCandy');")
cur.execute("SELECT currval('problems_id_seq');")
if(cur.rowcount > 0):
    pid = cur.fetchone()[0] ##store the assigned id

cur.execute("INSERT INTO problems_content VALUES(%s,'aennginif si  isngua ugn augouneaiurgn uonrg arug ar auiguoireaig ueagurarug eauib uah baurgb auireg be uibg bvananinaviunriu aiunr auiagui lljio');", pid)
cur.execute("INSERT INTO problem_set VALUES(DEFAULT,1,%s);", pid)
cur.execute("SAVEPOINT sp1;")

#if insertion fails, then rollsback to the last updated problem, that way we don't need to insert it again
try:
    cur.execute("INSERT INTO problems VALUES(DEFAULT, 'B', 'B.pdf', 2, 'Aca habría una descripción... Si se me ocurriera una!','notDesc');")
    cur.execute("SELECT currval('problems_id_seq');")
    cur.execute("INSERT INTO problems_content VALUES(%s,'ef pjpg reijg pirgisgji sgi');", pid)
    cur.execute("INSERT INTO problem_set VALUES(DEFAULT,1,%s);", pid)
except Exception, e:
    cur.execute("ROLLBACK TO sp1;")
    print "An error has ocurred, rollin'back to sp1!"
    print e
cur.execute("SAVEPOINT sp2;")
try:
    cur.execute("INSERT INTO problems VALUES(DEFAULT, 'C', 'C.pdf', 3, 'soa bashele, haga algo! T-T','soaBashele');")
    cur.execute("SELECT currval('problems_id_seq');")
    cur.execute("INSERT INTO problems_content VALUES(%s,'lala lalala lala lalala');", pid)
    cur.execute("INSERT INTO problem_set VALUES(DEFAULT,1,%s);", pid)
except Exception, e:
    cur.execute("ROLLBACK TO sp2;")
    print "An error has ocurred, rollin'back to sp2!"
    print e

conn.commit()
cur.close()
conn.close()
print "Insertion of test data finished."
