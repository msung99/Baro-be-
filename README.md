# Baro

본 프로젝트는 2023년 대학교 창업 동아리 멋쟁이사자처럼 & 현대 모비스 해커톤 출품작입니다.

### main branch 에 코드 내용반영시, 빌드가 되는 모습입니다. 

![image](https://user-images.githubusercontent.com/88240193/220641985-cdc5a973-96d4-4101-bf1e-b579b5894986.png)


## Branch Strategy

Github flow 전략을 사용합니다.

## Commit Massage Convention

```
type(file name): commit message
```

모든 `commit message`는 최대한 간략하게 작성합니다. `file name`의 경우, 특정 파일만을 수정한 경우에는 해당 파일 이름을 포함하지만, 여러 파일인 경우에는 미포함하여 작성합니다.

모든 `commit message` 앞에는 다음의 `type`을 작성합니다.

- `feat` : 새로운 기능을 추가한 경우
- `fix` : 버그를 고친 경우
- `design` : CSS 등 사용자 UI 디자인을 변경한 경우
- `refactor` : 프로덕션 코드 리팩토링의 경우 (새로운 기능이나 버그 수정 없이 현재 구현을 개선)
- `docs` : 문서를 수정한 경우
- `comment` : 필요한 주석 추가 및 변경의 경우
- `chore` : 위의 경우에 포함되지 않는 경우
