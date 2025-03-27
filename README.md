# 📘 프로젝트 개요: 메시징 기반 검색 시스템
## 🔎 배경 및 목적
트랜잭션 아웃박스 패턴에 대한 이해를 돕고,

검색 시스템에서 메시지 큐를 활용한 비동기 처리 구조를 직접 구현해보기 위해
Redis + Elasticsearch를 이용한 간단한 메시징 기반 키워드 검색 시스템을 제작.

# 🧱 전체 시스템 아키텍처
```
[ API Server ]
   |
   | ① 상품 등록/수정 요청
   v
[ DB + Redis Stream/PubSub ]
   |
   | ② 메시지 발행
   v
[ Worker Server ]
   |
   | ③ Redis 메시지 수신
   | ④ DB에서 상품 조회
   v
[ Elasticsearch ]
   |
   | ⑤ 인덱스 갱신
   v
[ 검색 서비스 ]
Elasticsearch는 빠른 검색 응답을 위해 색인 기반 문서 검색 기능을 제공
Redis Pub/Sub / Stream을 통해 비동기 이벤트 기반 인덱스 갱신을 수행
```

# ⚙️ 주요 기능 요약
## 기능	설명
- 상품 등록	DB에 저장 + Redis로 메시지 발행
- Pub/Sub	메시지를 즉시 브로드캐스트 (유실 가능)
- Redis Stream	메시지를 저장하고 병렬 소비 가능 (신뢰성 보장)
- ELS 인덱싱	저장된 상품 정보를 Elasticsearch에 동기화
- 검색 기능	ELS의 색인된 데이터에서 실시간 키워드 검색


# 결과 및 전체과정
https://velog.io/@msw0909/Redis-Pub-vs-Stream-with-ElasticSearch
