# Baro

본 프로젝트는 2023년 현대 모비스 해커톤 출품작입니다.

## Architecture (Devops & Infra 아키텍처)

![image](https://user-images.githubusercontent.com/88240193/220622794-0507af22-3814-459f-b6ee-d582373b0632.png)


## Project Stack (Back-end)

-  Framework : SpringBoot (Spring Data JPA, JPA)
-  CI/CD : Jenkins & Docker
-  Infra : AWS EC2, RDS, S3, CloudFront (for CDN Env.)
-  LoadBalancer : Nginx 1.7.1 (for Thread Pool)
-  Database : MySQL 8.0
-  OpenAI (based on Davinci-003 Model)

---

## 젠킨스 빌드 과정 (by Build Trigger & Github WebHook)

이번 프로젝트에 실제로 구축하고 작성했던 Devops 관련 블로깅 내용입니다.  

- [[CI/CD] Jenkins 기반 다중 Docker 컨테이너 : 애플리케이션 동시 배포 자동화하기](https://velog.io/@msung99/CICD-Jenkins-%EA%B8%B0%EB%B0%98-%EB%8B%A4%EC%A4%91-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-%EC%95%A0%ED%94%8C%EB%A6%AC%EC%BC%80%EC%9D%B4%EC%85%98-%EB%B0%B0%ED%8F%AC-%EC%9E%90%EB%8F%99%ED%99%94)
- [무중단 배포 아키텍처의 다양한 배포전략 (Rolling, Blue&Green, Canary 배포에 대해)](https://velog.io/@msung99/%EB%AC%B4%EC%A4%91%EB%8B%A8-%EB%B0%B0%ED%8F%AC-%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98%EB%A5%BC-%EC%9C%84%ED%95%9C-%EB%B0%B0%ED%8F%AC%EC%A0%84%EB%9E%B5Rolling-BlueGreen-Canary-%EC%A0%84%EB%9E%B5)
- [[Nginx] 로드밸런싱 환경에 HTTPS 프로토콜 적용 (feat. Let's Encrypt, Certbot)](https://velog.io/@msung99/Nginx-%EB%A1%9C%EB%93%9C%EB%B0%B8%EB%9F%B0%EC%8B%B1-%ED%99%98%EA%B2%BD%EC%97%90-HTTPS-%ED%94%84%EB%A1%9C%ED%86%A0%EC%BD%9C%EC%9D%84-%EC%A0%81%EC%9A%A9%ED%9B%84-%EB%B0%B0%ED%8F%AC%ED%95%98%EA%B8%B0-feat.-Lets-Encrypt-Certbot)
- [[CI/CD] Jenkins 를 이용한 Docker 컨테이너 기반 스프링부트 애플리케이션 배포 자동화](https://velog.io/@msung99/CICD-Jenkins-Docker-%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-SpringBoot-%EB%B0%B0%ED%8F%AC-%EC%9E%90%EB%8F%99%ED%99%94-%EA%B5%AC%EC%B6%95)
- [[AWS] AWS CloudFront, S3 를 활용하여 CDN 환경 구축하기](https://velog.io/@msung99/AWS-CloudFront-S3-%EB%A1%9C-CDN-%ED%99%98%EA%B2%BD-%EA%B5%AC%EC%B6%95%ED%95%98%EA%B8%B0)
- [[AWS & SpringBoot] AWS S3 에 다중 파일 업로드 API 구현 (feat. Spring Cloud AWS)](https://velog.io/@msung99/AWS-SpringBoot-AWS-S3-%EC%97%90-%EB%8B%A4%EC%A4%91-%ED%8C%8C%EC%9D%BC-%EC%97%85%EB%A1%9C%EB%93%9C-API-%EA%B5%AC%ED%98%84-feat.-Spring-Cloud-AWS)
- [[Nginx] Upstream 서버의 KeepAlive 주기를 조정하여 불필요한 TCP-handshake 과정 제거하기](https://velog.io/@msung99/%E3%84%B4%E3%84%B4%E3%84%B4)

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
