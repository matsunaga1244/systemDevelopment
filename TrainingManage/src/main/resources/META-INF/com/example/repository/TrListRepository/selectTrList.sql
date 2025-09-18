select
    ttt.NAME as NAME,
    CASE
    WHEN ttt.GENDER = '1' THEN '男性'
    WHEN ttt.GENDER = '2' THEN '女性'
    end as GENDER,
    CASE
    WHEN ttt.NEWHALFWAY = '1' THEN '新卒'
    WHEN ttt.NEWHALFWAY = '2' THEN '中途'
    end as NEWHALFWAY,
    ttt.TRAININGSTART as TRAININGSTART,
    ttt.PCNUMBER as PCNUMBER,
    ttt.STE2PASSE as STE2PASSE,
    ttl.NAME as LECTURERNAME
from
    TM_TR_TRAINEE ttt
    left join TM_TR_LECTURER ttl
    on ttt.LECTURERNAME = ttl.LECNUMBER
where
/*%if !(form.name).equals("")*/
	ttt.NAME LIKE /* @infix(form.name) */'name'
/*%end */
/*%if !(form.furigana).equals("")*/
	AND ttt.FURIGANA LIKE /* @infix(form.furigana) */'furigana'
/*%end */
/*%if form.newHalfway != null*/
	AND ttt.NEWHALFWAY = /* form.newHalfway */'newHalfway'
/*%end */
/*%if !(form.trainingStart).equals("")*/
	AND ttt.TRAININGSTART = /* form.trainingStart */'newHalfway'
/*%end */