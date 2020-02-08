-- EMPLOYEE ���̺��� ����� �̸�, �Ի���, �Ի� �� 6������ �� ��¥ ��ȸ
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 6)
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� �����, �Ի���-����, ����-�Ի��� ��ȸ
-- ��, ��Ī�� �ٹ��ϼ�1, �ٹ��ϼ�2�� �ϰ�
-- ��� ����ó��(����), ����� �ǵ��� ó��
SELECT EMP_NAME, FLOOR(HIRE_DATE - SYSDATE) �ٹ��ϼ�1, FLOOR(SYSDATE - HIRE_DATE) �ٹ��ϼ�2
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ����� Ȧ���� �������� ���� ��� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1;

-- EMPLOYEE ���̺��� �ٹ� ����� 20�� �̻��� ���� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12 >= 20;

-- EMPLOYEE ���̺��� �����, �Ի���, �Ի��� ���� �ٹ��ϼ��� ��ȸ
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE) - HIRE_DATE + 1
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ����� �̸�, �Ի���, �ٹ���� ��ȸ
-- �� �ٹ������ (����⵵ - �Ի�⵵)�� ��ȸ�ϼ���
-- 1) EXTRACT
SELECT EMP_NAME, HIRE_DATE, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
FROM EMPLOYEE;

-- 2) MONTHS_BETWEEN
SELECT EMP_NAME, HIRE_DATE, ROUND(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12)
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� �����, �޿� ��ȸ
-- �޿��� '\9,000,000' �������� ǥ��
SELECT EMP_NAME, CONCAT('\', TO_CHAR(SALARY, 'FM9,999,999'))
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� �̸�, �Ի��� ��ȸ
-- �Ի����� ���� ������ '2017�� 12�� 06�� (��)' �������� ���
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"��" MM"��" DD"��" "("DY")')
FROM EMPLOYEE;

-- ������ �޿��� �λ��ϰ��� �Ѵ�
-- �����ڵ尡 J7�� ������ �޿��� 10%�� �λ��ϰ�
-- �����ڵ尡 J6�� ������ �޿��� 15%�� �λ��ϰ�
-- �����ڵ尡 J5�� ������ �޿��� 20%�� �λ��ϸ�
-- �� �� ������ ������ �޿��� 5%�� �λ��Ѵ�.
-- ���� ���̺��� ������, �����ڵ�, �޿�, �λ�޿�(�� ����)�� ��ȸ�ϼ���
-- 1) DECODE
SELECT EMP_NAME, JOB_CODE, SALARY, DECODE(JOB_CODE, 'J7', SALARY*110, 'J6', SALARY*115, 'J5', SALARY*120, SALARY*105) �λ�޿�
FROM EMPLOYEE;

-- 2) CASE WHEN
SELECT EMP_NAME, JOB_CODE, SALARY, CASE WHEN JOB_CODE = 'J7' THEN SALARY*110
                                        WHEN JOB_CODE = 'J6' THEN SALARY*115
                                        WHEN JOB_CODE = 'J5' THEN SALARY*120
                                        ELSE SALARY*105 END �λ�޿�
FROM EMPLOYEE;

-- ���, �����, �޿�
-- �޿��� 500���� �̻��̸� '���'
-- �޿��� 300~500�����̸� '�߱�'
-- �� ���ϴ� '�ʱ�'���� ���ó���ϰ� ��Ī�� '����'���� �Ѵ�.
SELECT EMP_ID, EMP_NAME, CASE WHEN SALARY>=5000000 THEN '���'
                              WHEN SALARY>=3000000 AND SALARY<5000000 THEN '�߱�'
                              WHEN SALARY<30000000 THEN '�ʱ�' END ����
FROM EMPLOYEE;

-- EMPLOYEE���̺��� �μ��ڵ尡 D5�� ������ ���ʽ� ���� ���� ��ȸ
SELECT SALARY*12 + (1+ NVL(BONUS, 0))*SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';


-- ������, �����ڵ�, ���ʽ��� ���Ե� ����(��) ��ȸ
--  ��, ������ ��57,000,000 ���� ǥ�õǰ� ��
SELECT EMP_NAME, JOB_CODE, TO_CHAR(SALARY*12 + (1+ NVL(BONUS, 0))*SALARY, 'L99,999,9999')
FROM EMPLOYEE;

-- �μ��ڵ尡 D5, D9�� ������ �߿��� 2004�⵵�� �Ի��� ������ ���, �����, �μ��ڵ�, �Ի���
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D9' OR DEPT_CODE = 'D5') AND (TO_CHAR(HIRE_DATE, 'YYYY') = '2004');

-- ������, �Ի���, �Ի��� ���� �ٹ��ϼ� ��ȸ(��, �ָ��� �Ի��� ���� �ٹ��ϼ��� ������)
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE) - HIRE_DATE + 1
FROM EMPLOYEE;

-- �μ��ڵ尡 D5�� D6�� �ƴ� ������� ������, �μ��ڵ�, �������, ����(��) ��ȸ
--  ��, ��������� �ֹι�ȣ���� �����ؼ� ������ ������ �����Ϸ� ��µǰ� �ϰ�
--  ���̴� �ֹι�ȣ���� �����ؼ� ��¥�����ͷ� ��ȯ�� ���� ���
SELECT EMP_NAME, DEPT_CODE,/* TO_CHAR(TO_DATE(SUBSTR(EMP_NO, 1, 6), 'YYMMDD'), 'YY"��" MM"��" DD"��"') �������,*/
                    SUBSTR(EMP_NO,1,2) ||'��'||SUBSTR(EMP_NO,3,2)||'��'||SUBSTR(EMP_NO,5,2)||'��' �������,
                  (TO_CHAR(SYSDATE, 'YY') + 100 - TO_CHAR(TO_DATE(SUBSTR(EMP_NO, 1, 2), 'YY'), 'YY')) +1 ����
FROM EMPLOYEE;
    
-- �������� �Ի��Ϸ� ���� �⵵�� ������, �� �⵵�� �Ի��ο����� ���Ͻÿ�.
--  �Ʒ��� �⵵�� �Ի��� �ο����� ��ȸ�Ͻÿ�.
--  => to_char, decode, sum ���
--
--	-------------------------------------------------------------
--	��ü������   2001��   2002��   2003��   2004��
--	-------------------------------------------------------------
SELECT '��ü������', SUM(DECODE(TO_CHAR(HIRE_DATE, 'YY'), '01', 1, 0)) "2001��",
                    SUM(DECODE(TO_CHAR(HIRE_DATE, 'YY'), '01', 1, 0)) "2002��",
                    SUM(DECODE(TO_CHAR(HIRE_DATE, 'YY'), '01', 1, 0)) "2003��",
                    SUM(DECODE(TO_CHAR(HIRE_DATE, 'YY'), '01', 1, 0)) "2004��"
FROM EMPLOYEE;

--  �μ��ڵ尡 D5�̸� �ѹ���, D6�̸� ��ȹ��, D9�̸� �����η� ó���Ͻÿ�.
--   ��, �μ��ڵ尡 D5, D6, D9 �� ������ ������ ��ȸ��
-- 1) DECODE
SELECT EMP_NAME, DECODE(DEPT_CODE, 'D5', '�ѹ���', 'D6','��ȹ��','D7','������')
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR DEPT_CODE = 'D6' OR DEPT_CODE ='D7';

-- 2) CASE WHEN
SELECT EMP_NAME, CASE WHEN DEPT_CODE ='D5' THEN '�ѹ���'
                      WHEN DEPT_CODE ='D6' THEN '��ȹ��'
                      WHEN DEPT_CODE='D7' THEN '������' END
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR DEPT_CODE = 'D6' OR DEPT_CODE ='D7';