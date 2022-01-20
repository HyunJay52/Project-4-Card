package com.phoca.boot.service;

import com.phoca.boot.domain.posts.Posts;
import com.phoca.boot.domain.posts.PostsRepository;
import com.phoca.boot.web.dto.PostsListResponseDto;
import com.phoca.boot.web.dto.PostsResponseDto;
import com.phoca.boot.web.dto.PostsSaveRequestDto;
import com.phoca.boot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional(readOnly=true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다 id="+id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly=true) //readOnly: 트랜잭션 범위 유지, 조회기능만 남김 -> 조회속도 개선, 등록/수정/삭제 기능이 없을 경우 사용추천
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
        //.map(posts->new PostsListResponseDto(posts)) Dto로 변환하고 List로 반환하는 메소드
    }
}
